from graphene import ObjectType, Field, List, String, Int, Union, Argument, Schema
from flask import Flask
from graphql_server.flask import GraphQLView

# Fake data for our "databases"
fake_netflix_data = [
    {
        "title": "Stranger Things",
        "description": "When a young boy disappears, his mother, a police chief, and his friends must confront terrifying supernatural forces in order to get him back.",
        "release_date": "2016-07-15",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/80057281",
        "content_type": "TV Show"
    },
    {
        "title": "The Witcher",
        "description": "Geralt of Rivia, a mutated monster-hunter for hire, journeys toward his destiny in a turbulent world where people often prove more wicked than beasts.",
        "release_date": "2019-12-20",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/81115994",
        "content_type": "TV Show"
    },
    {
        "title": "Orange is the New Black",
        "description": "A privileged New Yorker ends up in a women's prison when a past crime catches up with her in this Emmy-winning series from the creator of 'Weeds'.",
        "release_date": "2013-07-11",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/70242311",
        "content_type": "TV Show"
    },
    {
        "title": "Narcos",
        "description": "The true story of Colombia's infamously violent and powerful drug cartels fuels this gritty gangster drama series.",
        "release_date": "2015-08-28",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/80025172",
        "content_type": "TV Show"
    },
    {
        "title": "Black Mirror",
        "description": "This sci-fi anthology series explores a twisted, high-tech world where humanity's greatest innovations and darkest instincts collide.",
        "release_date": "2011-12-04",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/70178217",
        "content_type": "TV Show"
    },
    {
        "title": "Bird Box",
        "description": "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
        "release_date": "2018-12-13",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/81092002",
        "content_type": "Movie"
    },
    {
        "title": "The Irishman",
        "description": "Hit man Frank Sheeran looks back at the secrets he kept as a loyal member of the Bufalino crime family in this acclaimed film from Martin Scorsese.",
        "release_date": "2019-11-27",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/81075792",
        "content_type": "Movie"
    },
    {
        "title": "Marriage Story",
        "description": "A stage director and his actor wife struggle through a grueling, coast-to-coast divorce that pushes them to their personal and creative extremes.",
        "release_date": "2019-08-02",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/81001742",
        "content_type": "Movie"
    },
    {
        "title": "The Ballad of Buster Scruggs",
        "description": "An anthology of six stories about the American West, each with a different style and tone, from the creators of 'Fargo' and 'No Country for Old Men'.",
        "release_date": "2018-11-16",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/80194761",
        "content_type": "Movie"
    },
    {
        "title": "The Shawshank Redemption",
        "description": "Wrongfully convicted, a brilliant banker begins a new life as a prisoner in a rough, corrupt penitentiary where he makes unlikely friends and finds redemption.",
        "release_date": "1994-09-23",
        "streaming_platform": "Netflix",
        "streaming_url": "https://www.netflix.com/watch/67064253",
        "content_type": "Movie"
    }
]

fake_disney_plus_data = [
    {
        "title": "The Mandalorian",
        "description": "After the fall of the Galactic Empire, a lone bounty hunter embarks on a mission to find and protect the Child, a mysterious and powerful being.",
        "release_date": "2019-11-12",
        "streaming_platform": "Disney Plus",
        "streaming_url": "https://www.disneyplus.com/watch/the-mandalorian/40c97dbd-5be5-4981-9bce-c5f24cf29ce6",
        "content_type": "TV Show"
    },
    {
        "title": "Star Wars: The Clone Wars",
        "description": "As the Clone Wars sweep through the galaxy, the heroic Jedi Knights struggle to maintain order and restore peace. Led by the wise and powerful Yoda, they fight against the dark side's forces and its powerful leader, the evil Darth Sidious.",
        "release_date": "2008-10-03",
        "streaming_platform": "Disney Plus",
        "streaming_url": "https://www.disneyplus.com/watch/star-wars-the-clone-wars/4a3a9a9e-7bef-4f38-bbb4-b9892f29d6f9",
        "content_type": "TV Show"
    },
    {
        "title": "The Simpsons",
        "description": "The satiric adventures of a working-class family in the misfit city of Springfield.",
        "release_date": "1989-12-17",
        "streaming_platform": "Disney Plus",
        "streaming_url": "https://www.disneyplus.com/watch/the-simpsons/6edb7f1a-6ceb-4b60-bdd5-7d4f4b0d9c2e",
        "content_type": "TV Show"
    },
    {
        "title": "Avengers: Endgame",
        "description": "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
        "release_date": "2019-04-26",
        "streaming_platform": "Disney Plus",
        "streaming_url": "https://www.disneyplus.com/watch/avengers-endgame/1b4c4c59-d7eb-4f0e-9a6a-46d2cfb6e5a6",
        "content_type": "Movie"
    },
    {
        "title": "Toy Story 4",
        "description": "When a new toy called \"Forky\" joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy.",
        "release_date": "2019-06-21",
        "streaming_platform": "Disney Plus",
        "streaming_url": "https://www.disneyplus.com/watch/toy-story-4/65eccd20-77bf-45a6-8e8f-3a3e2e0befd5",
        "content_type": "Movie"
    },
    {
        "title": "The Lion King",
        "description": "Simba idolizes his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own.",
        "release_date": "2019-07-19",
        "streaming_platform": "Disney Plus",
        "streaming_url": "https://www.disneyplus.com/watch/the-lion-king/6e7a8f30-b5d5-4e1e-b5f9-a01f3e9d3fb6",
        "content_type": "Movie"
    },
    {
        "title": "Moana",
        "description": "In Ancient Polynesia, when a terrible curse incurred by the Demigod Maui reaches an impetuous Chieftain's daughter's island, she answers the Ocean's call to seek out the Demigod to set things right.",
        "release_date": "2016-11-14",
        "streaming_platform": "Disney Plus",
        "streaming_url": "https://www.disneyplus.com/watch/moana/4e4b1a4e-a91f-4d50-9c61-9b9f23edb470",
        "content_type": "Movie"
    }
]

fake_amazon_prime_data = [
    {
        "title": "The Marvelous Mrs. Maisel",
        "description": "A housewife in 1958 decides to become a stand-up comedian.",
        "release_date": "2017-03-17",
        "streaming_platform": "Amazon Prime",
        "streaming_url": "https://www.amazon.com/dp/B074DZZJCC",
        "content_type": "TV Show"
    },
    {
        "title": "The Man in the High Castle",
        "description": "A glimpse into an alternate history of North America. What life after WWII may have been like if the Nazis had won the war.",
        "release_date": "2015-11-20",
        "streaming_platform": "Amazon Prime",
        "streaming_url": "https://www.amazon.com/dp/B01DTIKQ30",
        "content_type": "TV Show"
    },
    {
        "title": "The Boys",
        "description": "A group of vigilantes known informally as 'The Boys' set out to take down corrupt superheroes with no more than their blue-collar grit and a willingness to fight dirty.",
        "release_date": "2019-07-26",
        "streaming_platform": "Amazon Prime",
        "streaming_url": "https://www.amazon.com/dp/B07XK68BK5",
        "content_type": "TV Show"
    },
    {
        "title": "The Grand Tour",
        "description": "Follow Jeremy, Richard, and James, as they embark on an adventure across the globe. Driving new and exciting automobiles from manufacturers all over the world.",
        "release_date": "2016-11-18",
        "streaming_platform": "Amazon Prime",
        "streaming_url": "https://www.amazon.com/dp/B01M4PY4Y6",
        "content_type": "TV Show"
    },
    {
        "title": "The Big Sick",
        "description": "Pakistan-born comedian Kumail Nanjiani and grad student Emily Gardner fall in love but struggle as their cultures clash. When Emily contracts a mysterious illness, Kumail finds himself forced to face her feisty parents, his family's expectations, and his true feelings.",
        "release_date": "2017-06-23",
        "streaming_platform": "Amazon Prime",
        "streaming_url": "https://www.amazon.com/dp/B06XGZKV3F",
        "content_type": "Movie"
    },
    {
        "title": "The Salesman",
        "description": "While both participating in a production of 'Death of a Salesman,' a teacher's wife is assaulted in her new home, which leaves him determined to find the perpetrator over his wife's traumatized objections.",
        "release_date": "2016-12-02",
        "streaming_platform": "Amazon Prime",
        "streaming_url": "https://www.amazon.com/dp/B01N6RR2Q2",
        "content_type": "Movie"
    },
    {
        "title": "La La Land",
        "description": "While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.",
        "release_date": "2016-12-09",
        "streaming_platform": "Amazon Prime",
        "streaming_url": "https://www.amazon.com/dp/B01N5C1Y5O",
        "content_type": "Movie"
    }
]

# Define our GraphQL types
class NetflixResultType(ObjectType):
    title = Field(String)
    description = Field(String)
    release_date = Field(String)
    streaming_platform = Field(String)
    streaming_url = Field(String)
    content_type = Field(String)

class DisneyPlusResultType(ObjectType):
    title = Field(String)
    description = Field(String)
    release_date = Field(String)
    streaming_platform = Field(String)
    streaming_url = Field(String)
    content_type = Field(String)

class AmazonPrimeResultType(ObjectType):
    title = Field(String)
    description = Field(String)
    release_date = Field(String)
    streaming_platform = Field(String)
    streaming_url = Field(String)
    content_type = Field(String)

class StreamingResultType(ObjectType):
    title = Field(String)
    description = Field(String)
    release_date = Field(String)
    streaming_platform = Field(String)
    streaming_url = Field(String)
    content_type = Field(String)

# Define our GraphQL query
class Query(ObjectType):
    search_netflix_titles = List(NetflixResultType, query=Argument(String), description="search netflix")
    search_disney_plus_titles = List(DisneyPlusResultType, query=Argument(String), description="search disney plus")
    search_amazon_prime_titles = List(AmazonPrimeResultType, query=Argument(String), description="search amazon prime")

    search_all_titles = List(StreamingResultType, query=Argument(String), description="search all platforms")
    search_movies_titles = List(StreamingResultType, query=Argument(String), description="search movies on all platforms")
    search_series_titles = List(StreamingResultType, query=Argument(String), description="search series on all platforms")


    def resolve_search_all_titles(self, info, query):
        netflix_results = [x for x in fake_netflix_data if query in x["title"]]
        disney_plus_results = [x for x in fake_disney_plus_data if query in x["title"]]
        amazon_prime_results = [x for x in fake_amazon_prime_data if query in x["title"]]
        combined_results = netflix_results + disney_plus_results + amazon_prime_results
        return combined_results

    def resolve_search_movies_titles(parent, info, query):
        movies = []
        for movie in fake_netflix_data:
            if movie['content_type'] == 'Movie' and query in movie['title']:
                movies.append(movie)
        for movie in fake_disney_plus_data:
            if movie['content_type'] == 'Movie' and query in movie['title']:
                movies.append(movie)
        for movie in fake_amazon_prime_data:
            if movie['content_type'] == 'Movie' and query in movie['title']:
                movies.append(movie)
        return movies

    def resolve_search_series_titles(parent, info, query):
        tv_shows = []
        for tv_show in fake_netflix_data:
            if tv_show['content_type'] == 'TV Show' and query in tv_show['title']:
                tv_shows.append(tv_show)
        for tv_show in fake_disney_plus_data:
            if tv_show['content_type'] == 'TV Show' and query in tv_show['title']:
                tv_shows.append(tv_show)
        for tv_show in fake_amazon_prime_data:
            if tv_show['content_type'] == 'TV Show' and query in tv_show['title']:
                tv_shows.append(tv_show)
        return tv_shows

    def resolve_search_netflix_titles(self, info, query):
        results = [x for x in fake_netflix_data if query in x["title"]]
        return results

    def resolve_search_disney_plus_titles(self, info, query):
        results = [x for x in fake_disney_plus_data if query in x["title"]]
        return results

    def resolve_search_amazon_prime_titles(self, info, query):
        results = [x for x in fake_amazon_prime_data if query in x["title"]]
        return results

# Create the Flask app and GraphQL view
app = Flask(__name__)
app.add_url_rule(
    '/graphql',
    view_func=GraphQLView.as_view(
        'graphql',
        schema=Schema(query=Query),
        graphiql=True # for having the GraphiQL interface
    )
)

# Run the Flask app
if __name__ == '__main__':
    app.run(host="0.0.0.0" , port=8000)