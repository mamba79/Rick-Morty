package com.bankuish.msrickandmorty;

import com.bankuish.msrickandmorty.models.Character;
import com.bankuish.msrickandmorty.models.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;


@RestController
public class ConsumeAPI {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/characters/{id}")
    public List<Character> getCharacterList(@PathVariable("id") List<String> id) {

        List<Character> characters = new ArrayList<>();
        List<Response> response;


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);


        String url = "https://rickandmortyapi.com/api/character";
        String json;
        boolean morePages = true;

        while (morePages) {

            json = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

            try {
                response = mapper.reader().forType(new TypeReference<List<Response>>() {
                }).readValue(json);
                if (response != null) {
                    url = response.get(0).getInfo().getNext();
                    if (url == null) morePages = false;
                    if (response.get(0).getResults() != null) {
                        characters.addAll(response.get(0).getResults());
                    }
                }
            } catch (JsonProcessingException ex) {
                System.out.println("Exception:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return getRandomList(getPopularity(characters), id);
    }


    @RequestMapping(value = "/character/{id}")
    public Character getCharacterByID(@PathVariable("id") String id) {

        Character character = null;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        int popularity;

        String url = "https://rickandmortyapi.com/api/character/" + id;
        String json = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

        try {
            character = mapper.reader().forType(new TypeReference<Character>() {
            }).readValue(json);
            if (character.getEpisodeList() != null) {
                popularity = character.getEpisodeList().size();
                if (popularity <= 15)
                    character.setPopularity(1);
                else if (popularity <= 30)
                    character.setPopularity(2);
                else if (popularity > 31 && popularity <= 45)
                    character.setPopularity(3);
                else character.setPopularity(4);
                //character.setPopularity(character.getEpisodeList().size());
            }
        } catch (JsonProcessingException ex) {
            System.out.println("Exception:" + ex.getMessage());
            ex.printStackTrace();
        }
        return character;
    }

    private List<Character> getPopularity(List<Character> characters) {

        Character character;
        int popularity;
        List<Character> characterWithPopularity = new ArrayList<>();
        for (int i = 0; i < characters.size() - 1; i++) {
            character = characters.get(i);
            if (character != null) {
                if (character.getEpisodeList() != null) {
                    popularity = character.getEpisodeList().size();
                } else popularity = 0;
                if (popularity <= 15)
                    character.setPopularity(1);
                else if (popularity <= 30)
                    character.setPopularity(2);
                else if (popularity > 31 && popularity <= 45)
                    character.setPopularity(3);
                else character.setPopularity(4);
                characterWithPopularity.add(character);
            }
        }
        return characterWithPopularity.stream()
                .sorted(Comparator.comparingInt(Character::getPopularity).reversed())
                .collect(Collectors.toList());
    }

    private List<Character> getRandomList(List<Character> characters, List<String> id) {

        Random random = new java.util.Random();
        List<Character> randomCharacters = new ArrayList<>(5);
        int randomCharacter;
        String idCharacter;
        for (int i = 0; i < 5; i++) {
            randomCharacter = random.nextInt(characters.size());
            idCharacter = String.valueOf(characters.get(randomCharacter).getId());
            if (!id.contains(idCharacter))
                randomCharacters.add(characters.get(randomCharacter));
            else i--;
        }
        return randomCharacters;


    }
}
