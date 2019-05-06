# w4devoir

Peer-graded Assignment: Web application with database access

The purpose of this activity is to create a more complete web application that accesses the database. The activity is to be developed using Servlets, JSP and JDBC, following the MVC model. No other framework should be used.

The application to be developed is **a simple forum system**, where users can add topics and comments to topics. They get points for the actions they do on the system and a ranking screen shows the placement of the users.

Below is a description of the system screens:

* Login screen - This is the home screen. It has the login and password fields for the user to authenticate. If the user successfully authenticates, it must be redirected to the Topics screen. If you do not authenticate successfully, the user should be directed to that same screen, which should display an error message. You must have the link to the Cadastre Screen.
* Registration Screen - This screen has a form in which the user must enter their information (name, login, email and password) and register. When you enter user information, it is directed to the Login screen.
* Topics screen - This screen has a table with the topics created by the user. Each topic in the table will display the title and the name of the user who created it. When you click on a topic, the user goes to the Display Topic Screen. There is a link that goes to Screen Ranking and a link that goes to the Screen Inserts Topic.


* Screen Displays Topic - This screen displays the topic with the title of the topic, the name of who put it and its text. Below the topic the added comments are displayed. Each comment has only the text and the name of the person who entered it. Below all, there is a large text field and a button to add a new comment. When adding the comment, the user must be redirected to the same Display Topic Screen. There is a link back to the Topics screen.
* Insert Topic - This screen displays a form for adding a topic title and a large field of text to place your content. When submitting, the topic is entered and the user is redirected to the Topics screen.
* Ranking Screen - This screen displays the list of users sorted by the number of points they have. There should be a table with the placement, name, login and number of points. When a user enters a topic, he should earn 10 points and when adding a comment should earn 3 points. There is a link back to the Topics screen.

The following are the technical requirements of the application:

* The design of the screens can be created at the discretion of the users and it is okay to use a very simple design and focus more on the functionality.
* An MVC structure must be used, separating class responsibilities into layers. It is also suggested to create an intermediate layer between the Servlets and the classes that access the Database.
* Servlets should be used as the controller layer, JSP as the view layer and JDBC for database access. It is not allowed to use other frameworks (an exception would be to use interface components only for the visual part of the screen).
* The tests of the classes that access the database with DBUnit and at least 3 tests with the Selenium that involve the navigation between at least 2 screens must be delivered.
* The database structure used must be the one specified in the "Database structure"

**Note: The** class developed in Week 3 exercise can and should be taken advantage of!

When the application is ready, you should record a video of your computer screen by navigating through the application interface. This video should show: a user's registration, login execution, listing of topics, creation of a topic, the display of a topic, creation of a comment and the display of the ranking. It should be shown that the user's score increases when he creates topics and adds comments. This video should be uploaded to a publicly accessible repository (such as YouTube - if you want you can make it accessible from the link but not publicly listed) where reviewers can watch it from the link.

**PS: Do not use texts or offensive words in the examples you create!**

Must be delivered:

* Application design (in Eclipse or Netbeans) with all classes, pages and unit tests in a .zip file.
* The class code with Selenium tests in .java format (put all tests in a single class for submission)
* Link of the video demonstrating the use of the web application developed


Review criteria 
Will be considered in the evaluation:

* If requested features have been implemented.
* Whether functional requirements have been met.
* Whether the implementation used the requested technologies.
* If the layers were divided properly.
* If the code is organized.
* If the tests were created as requested.

### Database structure

Following are the tables that must be generated in the Postgres database for use by the application.

The user table below is the same as that used for the third week. It stores the users with their respective points. The topical table stores a forum topic, and has the title, content, and login information of the user who created it. The comment table stores the comments made to a topic, with the text, the login of the user who did it and the id of the related topic.

Note that the topical and comment tables have a column as the primary key that has an associated sequence to automatically generate the ids sequentially. That way, when entering the data, just ignore the field with id, which will be generated automatically.


sql1

```
CREATE TABLE usuario
(
  login text NOT NULL,
  email text,
  nome text,
  senha text,
  pontos integer,
  CONSTRAINT usuario_pkey PRIMARY KEY (login)
);
```

sql1 en

```
CREATE TABLE user
(
  login text NOT NULL,
  email text,
  name text,
  password text,
  integer points,
  CONSTRAINT user_pkey PRIMARY KEY (login)
);
```

sql2

```
CREATE SEQUENCE topico_id_topico_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE topico
(
  id_topico integer NOT NULL DEFAULT nextval('topico_id_topico_seq'::regclass),
  titulo text,
  conteudo text,
  login text,
  CONSTRAINT topico_pkey PRIMARY KEY (id_topico),
  CONSTRAINT topico_login_fkey FOREIGN KEY (login)
      REFERENCES usuario (login) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
```

sql2en

```
CREATE SEQUENCE topico_id_topico_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE topic
(
  id_topic integer NOT NULL DEFAULT nextval ('topico_id_topico_seq' :: regclass),
  title text,
  content text,
  login text,
  CONSTRAINT topico_pkey PRIMARY KEY,
  CONSTRAINT topico_login_fkey FOREIGN KEY (login)
      REFERENCES user (login) SIMPLE MATCH
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
```

sql3

```
CREATE SEQUENCE comentario_id_comentario_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE comentario
(
  id_comentario integer NOT NULL DEFAULT nextval('comentario_id_comentario_seq'::regclass),
  comentario text,
  login text,
  id_topico integer,
  CONSTRAINT comentario_pkey PRIMARY KEY (id_comentario),
  CONSTRAINT comentario_id_topico_fkey FOREIGN KEY (id_topico)
      REFERENCES topico (id_topico) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT comentario_login_fkey FOREIGN KEY (login)
      REFERENCES usuario (login) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
```
sql3en

```
CREATE SEQUENCE comment_id_commentario_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE comment
(
  com_internal integer NOT NULL DEFAULT nextval ('comment_id_commentary_seq' :: regclass),
  comment text,
  login text,
  integer id,
  CONSTRAINT comment_pkey PRIMARY KEY,
  CONSTRAINT comment_id_topico_fkey FOREIGN KEY (id_topico)
      REFERENCES topico (id_topico) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT comment_login_fkey FOREIGN KEY (login)
      REFERENCES user (login) SIMPLE MATCH
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
```