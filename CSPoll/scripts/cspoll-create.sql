CREATE TABLE poll (
         poll_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
         description VARCHAR(255),
		 allow_multiple_answer boolean 
       );
CREATE TABLE poll_option(
         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		 poll_id INT,
		 option_string VARCHAR(255),
		 vote_count INT DEFAULT 0

);
CREATE TABLE poll_ip(
		poll_id INT,
		ip VARCHAR(39)

);