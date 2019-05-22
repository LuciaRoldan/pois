# language: es

Característica: Obtener el punto más cercano a mi ubicación
    Para tener que caminar poco
    Como usuario
    Quiero obtener el punto de interes de un servicio más cercano a mi ubicación acutal

Escenario: Obtener el punto más cercano a mi ubicación
    Dado que estoy en -34.603765 y -58.381571
    Cuando pido el POI mas cercano del servicio pizzerias
    Entonces el servicio devuelve solo Las cuartetas

Escenario:
    Dado que estoy en -34.603765 y 58.381572
    Cuando pido el POI mas cercano del servicio pizzerias
    Entonces el servicio devuelve el mensaje "el punto ingresado es invalido"

Escenario:
    Dado que estoy en -34.603765 y 58.381573
    Cuando pido el POI mas cercano del servicio pizzerias
    Entonces el servicio no devuelve un POI
