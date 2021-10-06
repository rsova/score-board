Drop table if exists User;
Create table User (user_id number , name string,  overallScore number);
Drop table if exists Score;
Create table Score (id number , user_id number, category string, value number);


