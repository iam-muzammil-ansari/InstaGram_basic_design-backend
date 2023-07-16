# Instagram Basic Design Backend

## Table of Contents
- [Frameworks and Language Used](#frameworks-and-language-used)
- [Data Flow](#data-flow)
  - [Controller](#controller)
  - [Services](#services)
  - [Repository](#repository)
  - [Database Design](#database-design)
- [Data Structures Used](#data-structures-used)
- [Project Summary](#project-summary)
- [Getting Started](#getting-started)
- [Testing Endpoints](#testing-endpoints)
- [License](#license)

## Frameworks and Language Used
- Spring Boot
- Java

## Data Flow

### Controller
The controller package contains the following classes:
- `PostController`: Handles requests related to posts, including creating a post, retrieving all posts, and getting a post by ID.
- `UserController`: Handles user-related requests, such as user sign-up, sign-in, updating user details, retrieving a user by email, and getting all users.

### Services
The service package contains the following classes:
- `PostService`: Provides services for creating posts, retrieving all posts, and getting a post by ID.
- `UserService`: Provides services for user sign-up, sign-in, updating user details, retrieving a user by email, and getting all users.

### Repository
The repository package contains the following interfaces:
- `AuthRepo`: Repository interface for managing authentication tokens.
- `PostRepo`: Repository interface for managing posts.
- `UserRepo`: Repository interface for managing users.

### Database Design
The following database tables are used in the project:
- `users`: Stores user details such as first name, last name, age, email, password, and phone number.
- `posts`: Stores post data, including the post ID, creation date, update date, post data, and the user who created the post.
- `authentication_token`: Stores authentication tokens, including the token ID, token value, token creation date, and the associated user.

## Data Structures Used
- `Post`: Represents a post, containing fields such as the post ID, creation date, update date, post data, and the user who created the post.
- `User`: Represents a user, containing fields such as the user ID, first name, last name, age, email, password, and phone number.
- `AuthenticationToken`: Represents an authentication token, containing fields such as the token ID, token value, token creation date, and the associated user.

## Project Summary
The Instagram Basic Design Backend project is built using Spring Boot and Java. It provides functionalities for user sign-up, sign-in, creating and retrieving posts, updating user details, and managing authentication tokens. The project follows a three-tier architecture, with controllers handling incoming requests, services providing business logic, and repositories managing data access.

## Getting Started
To get started with the Instagram Basic Design Backend project:
1. Clone the project repository from here -> [Instagram Basic Design Backend](https://github.com/ayaan097/InstaGram_basic_design-backend.git).
2. Set up a MySQL database and update the `application.properties` file with your database configuration.
3. Run the application using an IDE or the command line.
4. The application will start, and you can now make requests to the provided endpoints.

## Testing Endpoints
To test the endpoints of the Instagram Basic Design Backend project, you can use tools like Postman or cURL. Here are some example requests:

- **Create a post**:
  - URL: `POST /post/create`
  - Request Body: JSON object representing the post data
  - Request Parameters: `email` and `token` for authentication
  - Response: Success message or error message

- **Get all posts**:
  - URL: `GET /post/posts`
  - Response: List of all posts

- **Get a post by ID**:
  - URL: `GET /post/{postId}`
  - Path Variable: `postId` specifying the post ID
  - Response: Post object with the specified ID

- **User sign-up**:
  - URL: `POST /user/signup`
  - Request Body: JSON object representing the user data
  - Response: Sign-up status message

- **User sign-in**:
  - URL: `POST /user/signin`
  - Request Body: JSON object containing the user's email and password
  - Response: Sign-in status message or token sent to the user's email

- **Update user details**:
  - URL: `PUT /user/update`
  - Request Body: JSON object representing the updated user data
  - Request Parameters: `email` and `token` for authentication
  - Response: Success message or access denied message

- **Get user by email**:
  - URL: `GET /user/{email}`
  - Path Variable: `email` specifying the user's email
  - Response: User object with the specified email

- **Get all users**:
  - URL: `GET /user/users`
  - Response: List of all users

- **User sign-out**:
  - URL: `DELETE /user/signout`
  - Request Parameters: `email` and `token` for authentication
  - Response: Sign-out status message

## License
This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
