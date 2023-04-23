# sampleapirest

Il s'agit d'une simple API REST pour la gestion des employés d'une société X.
Les employées sont stoquées dans une base de données H2. 
L'API implémente les opérations CRUD pour l'exploitation de cette base de données.


## Installation
L'API n'est pas fournit en un fichier d'installation. Il s'agit simplement  d'un dossier à télécharger et à importer dans votre IDE préféré.

## Contrat
Cette section décrit la manière de communiquer et d'interagir avec l'API.

### Récupération de tous les employés
```
Request
  URI: http://localhost:9001/
  HTTP Verb: GET
  Body: Empty

Response:
  HTTP Status:
    200 OK if all employees are successfully retrieved
    204 NO CONTENT The request has been processed but no employee exists in the database

  Response Body Type: JSON
  
  Example Response Body:
    [
      {
          "id": 1,
          "firstName": "Colleen ",
          "lastName": "Myers",
          "salary": "$1000"
      },
      {
          "id": 2,
          "firstName": "Monica ",
          "lastName": "Webb",
          "salary": "$1100"
      }
  ]
```

### Récupération d'un employé
```
Request
  URI: http://localhost:9001/{id}
  HTTP Verb: GET
  Body: Empty

Response:
  HTTP Status:
    200 OK if the Employee was successfully retrieved
    404 NOT FOUND if Employee cannot be found
    
  Response Body Type: JSON
  
  Example Response Body:
    {
        "id": 1,
        "firstName": "Colleen ",
        "lastName": "Myers",
        "salary": "$1000"
    }
```
### Ajout d'un employé
```
Request
  URI: http://localhost:9001/
  HTTP Verb: POST
  Body: 
    {
        "firstName": "John",
        "lastName": "Doe",
        "salary": "$5000"
    }

Response:
  HTTP Status:
    201 CREATED The request has been fulfilled and a new employee being created.
    
  Response Body Type: JSON
  
  Example Response Body:
    {
        "id": 6,
        "firstName": "John",
        "lastName": "Doe",
        "salary": "$5000"
    }
```
### Modification totale d'un employé
```
Request
  URI: http://localhost:9001/{id}
  HTTP Verb: PUT
  Body: 
    {
        "firstName": "Sarah",
        "lastName": "Hant",
        "salary": "$4500"
    }

Response:
  HTTP Status:
    204 NO CONTENT The server successfully processed the request, but is not returning any content.
    404 NOT FOUND if the id does not exist
```
### Modification partielle d'un employé
```
Request
  URI: http://localhost:9001/{id}
  HTTP Verb: PATCH
  Body: 
    {
        "salary": "$4500"
    }

Response:
  HTTP Status:
    204 NO CONTENT The server successfully processed the request, but is not returning any content.
    404 NOT FOUND if the id does not exist
```
### Suppression d'un employé
```
Request
  URI: http://localhost:9001/{id}
  HTTP Verb: DELETE
  Body: Empty

Response:
  HTTP Status:
    204 NO CONTENT The server successfully processed the request, but is not returning any content.
    404 NOT FOUND if the id does not exist
```
