# urlshortner
Launch the application as Java application or execute the command: mvn spring-boot:run
Application launches on URL: http://localhost:8081/#!/home

For Docker execution please follow the below commands:

docker build -f Dockerfile -t urlshortenerdocker

docker run -p 8081:8081 urlshortenerdocker

Application launches on URL: http://localhost:8081/#!/home

Enter your shortened URL in the text box and click on **Generate!**.  The table below will be loaded with the shotened URL and on clicking the shortened URL, it redirects to original URL


