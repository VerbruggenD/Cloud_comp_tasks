# Movie and series search engine across platforms

This API tries to solve a problem a lot more people are facing, "on what streaming service could this show or movie could be?"
And so here 3 services are used: netflix, amazon prime and disney plus. The services are faked with "databases" but would be integrated by using the APIs of the services themselves with developer access.

## Delivery

The docker image from docker hub can be accessed via the following commands:

```
docker pull dieterverbruggen/cloud_computing:media_search_engine
docker run -dp 8000:8000 dieterverbruggen/cloud_computing:media_search_engine
```

When you want to build the image yourself, you can use the following commands:
```
docker build -t dieterverbruggen/cloud_computing:media_search_engine .
docker run -dp 8000:8000 dieterverbruggen/cloud_computing:media_search_engine
```

## Features
- Searching on individual platforms
- Searching on all platforms
- Searching for only movies or series
- Searching methods could be:
  - Title
  - ReleaseDate
  - Key words of the disciption
  - Categories
  - Only the title search is implemented but this could be expanded to the other features.
- Recommending titles across all platforms (not implemented)
- Caching frequently searched items (not implemented)

This is a query for 3 searches for the interface.
http://127.0.0.1:8000/graphql
```
{
  searchAllTitles(query: "Story") {
    title
    releaseDate
    streamingUrl
    contentType
  }
  searchMoviesTitles(query: "Big") {
    title
    releaseDate
    streamingUrl
    contentType
  }
  searchSeriesTitles(query: "Grand") {
    title
    releaseDate
    streamingUrl
    contentType
  }
}
```

The fake databases are quite extensive but looking for the available titles is still recommended for testing.