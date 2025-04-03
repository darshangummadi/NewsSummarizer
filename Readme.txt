news-summarizer/
├── auth-service/
├── news-service/
├── summarizer-service/
├── tts-service/
├── bookmarks-service/
└── frontend/ (for React app)


Plan for 2 weeks:
Day 1
Set up GitHub repo(s), create Spring Boot skeletons for all 5 services
Day 2
Implement Auth Service (Register/Login, JWT, PostgreSQL)
Day 3
NewsFetcher Service: integrate NewsAPI/RSS + store articles in MongoDB
Day 4
Summarizer Service: call OpenAI API (or stub HuggingFace) from Java
Day 5
SaveForLater Service: Bookmark CRUD with user linking
Day 6
TTS Service: Convert text to audio using API (Google/ElevenLabs)
Day 7
React setup + Auth pages (login/register)
Day 8
News Feed page: call NewsFetcher, show titles + summaries
Day 9
Integrate Summarizer (summary box on each article)
Day 10
SaveForLater page: bookmark/save/unbookmark articles
Day 11
Audio Player UI + backend TTS API
Day 12
Polish UI: error states, loading states, responsiveness
Day 13
Dockerize microservices, test them locally
Day 14
Final testing, deploy to Render/Vercel, write README/demo notes
