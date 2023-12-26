## **Restaurant Management Platform**

An online restaurant management platform application having backend REST API made in Java Springboot JPA-Hibernate with MySQL database and hosted on AWS Elasticbeanstalk environment. 

### Technologies used:

* **Backend**: Java, Springboot
* **Database**: MySQL
* **Hosted on**: AWS ElasticBeanstalk Environment with Amazon RDS

### Functional Requirements:

* Application to have capability to add/ store desired data through set of APIs.
* Data to include details about restaurants, their menu, and customizable food items.
* Working set of APIs to fetch/ view detailed list of restaurants and their details, curated list of restaurants and food items based on various filters like rating, cuisine and average cost per person. 

### Features:

* 3 types of Users: Guest, Customer, and Admin.
* Account signup and Login using personal details.
* JWT token generated for future authentication purposes upon successful login.
* 3 sets of API groups based on types of users.
* Admin APIs deal with Restaurants, Menu items, food item development along with management of users.
* Customer APIs include posting a restaurant review, updating restaurant rating etc.
* Guest APIs allow user to view details of a restaurant, search, sort and filter to get curated list of restaurant and food items as per requirement.
* API definitions can be found in [Postman folder](src/main/resources/static/Postman_Files). 

### Application WorkFlow :

![Restaurant Management Platform Workflow.png](src%2Fmain%2Fresources%2Fstatic%2FRestaurant%20Management%20Platform%20Workflow.png)

### Entity Relationship Diagram :
![Restaurant-management-platform-ER-diagram.png](src%2Fmain%2Fresources%2Fstatic%2FRestaurant-management-platform-ER-diagram.png)

### AWS Deployment:

* Amazon RDS instance of MySQL created. MySQL workbench used to view/handle data.
* [Application properties](src/main/resources/application.properties) was dully updated with required configurations for MySQL database.
* Docker image built using [Docker file](Dockerfile) and pushed into a repository on dockerhub. Check [deploy_docker.sh](scripts/deploy_docker.sh).
* Amazon BeanStalk environment with appropriate service role and instance profile created.
* [Docker run](Dockerrun.aws.json) file was created and uploaded onto the above created beanstalk environment.
* Currently, application environment is running at -http://restaurant-management-platform-env.eba-f86mdmbm.us-east-1.elasticbeanstalk.com/restaurant-platform/v1/