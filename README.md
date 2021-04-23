# Rick-Morty

Rick and morty is a spring boot microservice, it will retrieve up to 5 random Rick and Morty characters sorted by popularity

Also,this microservice implement the calculation of popularity index based on the number of episodes that the character appears, this index also is returned
 
Popularity index 1: Less than 15 episodes

Popularity index 2: More than 16 and less than 30 episodes

Popularity index 3: More than 31 and less than 45 episodes

Popularity index 4: More than 46 episodes

In the future this popularity will be calculated calling other API Rest

## Run

Through command line: java -jar /target/ms-rickandmorty-0.0.1-SNAPSHOT.jar

Docker

docker build -t rick-morty .
docker run -p 8080:8080 rick-morty

## Usage

```python
http://localhost:8080/character/{id}
    Return the character associated to the id parameter

http://localhost:8080/characters/{id}
    Return 5 random characters excluding the ids in the input parameter
Example:
http://localhost:8080/characters/1,45,32
    Return a list with 5 characters but anyone has these ids: 1,45,32
http://localhost:8080/characters/
    Return a list with 5 characters without exclusion   

All the request and response are in a log
```

