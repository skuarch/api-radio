DROP DATABASE IF EXISTS api_radio;
CREATE DATABASE api_radio;
USE api_radio;

CREATE TABLE user (
  user_id bigint(20) NOT NULL AUTO_INCREMENT,
  user_email varchar(64) NOT NULL,
  user_password varchar(35) NOT NULL,
  user_is_soft_deleted tinyint(1) DEFAULT '0',
  user_is_active tinyint(1) DEFAULT '1',
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE role (
  role_id bigint(20) NOT NULL AUTO_INCREMENT,
  role_name varchar(64) NOT NULL,
  role_is_soft_deleted tinyint(1) DEFAULT '0',
  PRIMARY KEY (role_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
CREATE TABLE country (
  country_id bigint(20) NOT NULL AUTO_INCREMENT,
  country_name_en varchar(255) NOT NULL,
  country_name_es varchar(255) NOT NULL,
  PRIMARY KEY (country_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE genre (
  genre_id bigint(20) NOT NULL AUTO_INCREMENT,
  genre_name_en varchar(255) NOT NULL,
  genre_name_es varchar(255) NOT NULL,
  PRIMARY KEY (genre_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE language (
  language_id bigint(20) NOT NULL AUTO_INCREMENT,
  language_name_en varchar(255) NOT NULL,
  language_name_es varchar(255) NOT NULL,  
  PRIMARY KEY (language_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE keyword (
  keyword_id bigint(20) NOT NULL AUTO_INCREMENT,
  keyword_name varchar(255) NOT NULL,
  PRIMARY KEY (keyword_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE station_type (
  station_type_id bigint(20) NOT NULL AUTO_INCREMENT,
  station_type_name varchar(255) NOT NULL,
  PRIMARY KEY (station_type_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE request (
  request_id bigint(20) NOT NULL AUTO_INCREMENT,
  request_accept varchar(255) DEFAULT NULL,
  request_accept_encoding varchar(255) DEFAULT NULL,
  request_attribute_names text,
  request_auth_type varchar(255) DEFAULT NULL,
  request_charactect_encoding varchar(255) DEFAULT NULL,
  request_connection varchar(255) DEFAULT NULL,
  request_content_length int(11) DEFAULT NULL,
  request_content_type varchar(255) DEFAULT NULL,
  request_date varchar(255) DEFAULT NULL,
  request_header_names varchar(255) DEFAULT NULL,
  request_local_address varchar(255) DEFAULT NULL,
  request_local_port int(11) DEFAULT NULL,
  request_locale varchar(255) DEFAULT NULL,
  request_method varchar(255) DEFAULT NULL,
  request_origin varchar(255) DEFAULT NULL,
  request_parameter_names text,
  request_path_info varchar(255) DEFAULT NULL,
  request_protocol varchar(255) DEFAULT NULL,
  request_remote_host varchar(255) DEFAULT NULL,
  request_remote_port int(11) DEFAULT NULL,
  request_remote_user varchar(255) DEFAULT NULL,
  request_scheme varchar(255) DEFAULT NULL,
  request_servlet_path varchar(255) DEFAULT NULL,
  request_uri varchar(255) DEFAULT NULL,
  request_url varchar(255) DEFAULT NULL,
  request_user_agent varchar(255) DEFAULT NULL,
  PRIMARY KEY (request_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE station_genre (
  station_id bigint(20) NOT NULL,
  genre_id bigint(20) NOT NULL,
  KEY UK_efae70c8ppnfmsnomwx0n1tbm (genre_id),
  CONSTRAINT FK_efae70c8ppnfmsnomwx0n1tbm FOREIGN KEY (genre_id) REFERENCES genre (genre_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE station_keyword (
  station_id BIGINT(20) NOT NULL,
  keyword_id BIGINT(20) NOT NULL,  
  KEY UK_40n3dyktpd2d242cp6b066b7d (keyword_id),
  CONSTRAINT FK_40n3dyktpd2d242cp6b066b7d FOREIGN KEY (keyword_id) REFERENCES keyword (keyword_id)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE station_language (
  station_id bigint(20) NOT NULL,
  language_id bigint(20) NOT NULL,
  KEY UK_qxhbkrn7jmqsj3v6uf7cn2bob (language_id),
  CONSTRAINT FK_qxhbkrn7jmqsj3v6uf7cn2bob FOREIGN KEY (language_id) REFERENCES language (language_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE station (
  station_id bigint(20) NOT NULL AUTO_INCREMENT,
  station_active tinyint(4) DEFAULT NULL,
  station_clicks int(11) DEFAULT NULL,
  station_creation_date varchar(255) DEFAULT NULL,
  station_description varchar(255) NOT NULL,
  station_frecuencie varchar(255) DEFAULT NULL,
  station_is_soft_deleted int(1) NOT NULL DEFAULT '0',
  station_modulating varchar(255) DEFAULT NULL,
  station_name varchar(255) NOT NULL,
  station_position int(11) DEFAULT NULL,
  station_url_streaming varchar(255) NOT NULL,
  station_website varchar(255) DEFAULT NULL,
  station_country_id bigint(20) NOT NULL,
  station_type_id bigint(20) NOT NULL,
  PRIMARY KEY (station_id),
  UNIQUE KEY UK_smxm5nxgwu6akahf8gp7lfmx (station_name),
  UNIQUE KEY UK_f2nymlru25t3lpbwcxxkhm0y6 (station_url_streaming),
  KEY FK_9rbrs9n9ps2no77o6y0tn9k8t (station_country_id),
  KEY FK_foc2bt0pu9xuyajg1s17onxoe (station_type_id),
  CONSTRAINT FK_9rbrs9n9ps2no77o6y0tn9k8t FOREIGN KEY (station_country_id) REFERENCES country (country_id),
  CONSTRAINT FK_foc2bt0pu9xuyajg1s17onxoe FOREIGN KEY (station_type_id) REFERENCES station_type (station_type_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
