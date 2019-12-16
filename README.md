# jsonql-elastic-ql

ElasticSearch JSON query builder using GSON.

ElasticSearch comes with no default JSON query builder for the [low level client](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/master/java-rest-low.html), while the [high level client](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/master/java-rest-high.html) has really heavy dependencies. This lib fills the gap with very simple GSON-based JSON builder for ElasticSearch queries with a fluent interface:
 
```java
EQLRoot.of()
    .withQuery(EQLBoolComponent.of(EQLBool.of()
        .withShould(EQLMatchComponent.of("text", EQLMatchQuery.of("middle").withAutoFuzziness()))
        .withShould(EQLMatchPhrasePrefixComponent.of("textid", EQLMatchPhrasePrefixQuery.of("phrase-a")))
        .withFilter(EQLBoolComponent.of(EQLBool.of()
            .withShould(EQLTermComponent.of("enumVal", EQLTermQuery.of("C")))
            .withShould(EQLTermComponent.of("enumVal", EQLTermQuery.of("A")))))
        .withFilter(EQLRangeComponent.of("longVal", EQLRangeQuery.ofGte(1L).withLte(3L)))))
    .withHighlight(EQLHighlight.of("text", "textid"))
```

What gives as a result the following JSON:

```json
{
  "query": {
    "bool": {
      "should": [
        {
          "match": {
            "text": {
              "fuzziness": "AUTO",
              "query": "middle"
            }
          }
        },
        {
          "match_phrase_prefix": {
            "textid": {
              "query": "phrase-a"
            }
          }
        }
      ],
      "filter": [
        {
          "bool": {
            "should": [
              {
                "term": {
                  "enumVal": {
                    "value": "C"
                  }
                }
              },
              {
                "term": {
                  "enumVal": {
                    "value": "A"
                  }
                }
              }
            ]
          }
        },
        {
          "range": {
            "longVal": {
              "gte": 1,
              "lte": 3,
              "boost": 1.0
            }
          }
        }
      ]
    }
  },
  "highlight": {
    "fields": {
      "text": {},
      "textid": {}
    }
  }
}
```  
 
See more examples in [this test](src/test/java/com/lifeinide/jsonql/elasticql/test/ElasticQLTest.java).

We currently support only some subset of ElasticSearch Query DSL, but forks and pull requests are welcome :)

## Why GSON?

GSON is used by `org.hibernate:hibernate-search-elasticsearch` and the primary usage of this lib is [jsonql-hibernate-search-elastic](https://github.com/json-ql/jsonql-hibernate-search-elastic), so GSON seems to be a right choice,  while for other Jackson-based application it drags no additional dependencies.   

## How to use

To use this library please add it as your gradle/maven dependency with [these remarks](https://github.com/json-ql/jsonql-core#how-to-use):

```groovy
dependencies {
    implementation 'com.lifeinide.jsonql:jsonql-elastic-ql:VERSION'
}
```
