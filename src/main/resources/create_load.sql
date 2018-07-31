# Create the schema if necessary.
CREATE SCHEMA IF NOT EXISTS ProjectFIFA;
USE ProjectFIFA;

DROP TABLE IF EXISTS UserSquadJunction;
DROP TABLE IF EXISTS SquadPlayerJunction;
DROP TABLE IF EXISTS NonGKStat;
DROP TABLE IF EXISTS GKStat;
DROP TABLE IF EXISTS Player;
-- DROP TABLE IF EXISTS ClubLogo;
-- DROP TABLE IF EXISTS NationFlag;
DROP TABLE IF EXISTS LeagueLogo;
DROP TABLE IF EXISTS Squad;
DROP TABLE IF EXISTS Formation;
DROP TABLE IF EXISTS Free;
DROP TABLE IF EXISTS Premium;
DROP TABLE IF EXISTS User;


CREATE TABLE User (
  username VARCHAR(255),
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  ispremium BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT pk_User_UserName PRIMARY KEY (username)
);

CREATE TABLE Free (
  username VARCHAR(255),
  searchcredit INT DEFAULT 20,
  CONSTRAINT pk_Free_UserName
    PRIMARY KEY (username),
  CONSTRAINT fk_Free_UserName
    FOREIGN KEY (username)
    REFERENCES User(username)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Premium (
  username VARCHAR(255),
  vipexp DATE NOT NULL,
  viplevel INT,
  creditcardnum BIGINT,
  creditcardexp DATE NOT NULL,
  CONSTRAINT pk_Premium_UserName
    PRIMARY KEY (username),
  CONSTRAINT fk_Premium_UserName
    FOREIGN KEY (username)
    REFERENCES User(username)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Formation (
  formation_name VARCHAR(255),  
  formationphoto VARCHAR(255),
  pos1 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos2 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos3 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos4 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos5 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos6 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos7 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos8 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos9 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos10 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  pos11 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  CONSTRAINT pk_Formation_FormationName PRIMARY KEY (formation_name)
 );
 
 CREATE TABLE Squad (
  squad_id INT AUTO_INCREMENT,
  squadname VARCHAR(255),
  formation_name VARCHAR(255),
  chemisty INT,
  rating INT,
  CONSTRAINT pk_Squad_SquadID PRIMARY KEY(squad_id),
  CONSTRAINT fk_Squad_FormationName 
    FOREIGN KEY (formation_name)
    REFERENCES Formation(formation_name)
    ON UPDATE CASCADE ON DELETE SET NULL
);

-- CREATE TABLE ClubLogo (
--   ClubName VARCHAR(255),
--   ClubLogo VARCHAR(255),
--   CONSTRAINT pk_ClubLogo_ClubName PRIMARY KEY (ClubName)
-- );
-- 
-- CREATE TABLE NationFlag (
--   Nation VARCHAR(255),
--   Flag VARCHAR(255),
--   CONSTRAINT pk_NationFlag_Nation PRIMARY KEY (Nation)
-- );

-- CREATE TABLE LeagueLogo (
--   LeagueName VARCHAR(255),
--   LeagueLogo VARCHAR(255),
--   CONSTRAINT pk_LeagueLogo_LeagueName PRIMARY KEY (LeagueName)
-- );

CREATE TABLE Player(
  player_id BIGINT,
  player_name VARCHAR(255),
  nation VARCHAR(255),
  flag VARCHAR(255),
  photo VARCHAR(255),
  club VARCHAR(255),
  clublogo VARCHAR(255),
  league VARCHAR(255),
  skills INT,
  weak_foot INT,
  height INT,
  weight INT,
  pos ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  overall INT,
  pace INT,
  dribbling INT,
  shooting INT,
  defending INT,
  physicality INT,
  passing INT,
  CONSTRAINT pk_Player_PlayerID PRIMARY KEY (player_id)
  -- CONSTRAINT fk_Player_ClubName FOREIGN KEY (ClubName)
--     REFERENCES ClubLogo(ClubName)
--     ON UPDATE CASCADE ON DELETE SET NULL,
--   CONSTRAINT fk_Player_Nation FOREIGN KEY (Nation)
--     REFERENCES NationFlag(Nation)
--     ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE GKStat (
  player_id BIGINT,
  gk INT,
  CONSTRAINT pk_GKStat_PlayerID PRIMARY KEY (player_id),
  CONSTRAINT fk_GKStat_PlayerID FOREIGN KEY (player_id)
    REFERENCES Player(player_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE NonGKStat (
  player_id BIGINT,
  rw INT,
  rf INT,
  rm INT,
  rb INT,
  st INT,
  cf INT,
  cam INT,
  cm INT,
  cdm INT,
  cb INT,
  lw INT,
  lm INT,
  lb INT,
  lf INT,
  CONSTRAINT pk_NonGKStat_StatID PRIMARY KEY (player_id),
  CONSTRAINT fk_NonGKStat_StatID FOREIGN KEY (player_id)
    REFERENCES Player(player_id)
    ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE UserSquadJunction (
  username VARCHAR(255),
  squad_id INT,
  CONSTRAINT pk_User_Squad PRIMARY KEY (username, squad_id),
  CONSTRAINT fk_UserSquad_User FOREIGN KEY (username)
    REFERENCES User (username),
  CONSTRAINT fk_UseSquad_Squad  FOREIGN KEY (squad_id)
  REFERENCES Squad (squad_id)
);

CREATE TABLE SquadPlayerJunction (
  squad_id INT,
  player_id BIGINT,
  pos_number ENUM('ONE','TWO','THREE','FOUR','FIVE','SIX','SEVEN','EIGHT','NINE','TEN','ELEVEN'),
  CONSTRAINT pk_Squad_Player PRIMARY KEY (squad_id,player_id),
  CONSTRAINT fk_SquadPlayer_Squad  FOREIGN KEY (squad_id)
    REFERENCES Squad (squad_id),
  CONSTRAINT fk_SquadPlayer_Player FOREIGN KEY (player_id) 
    REFERENCES Player (player_id)
);


##################################
# Load Data
##################################

-- # Load ClubLogo
-- LOAD DATA INFILE '/tmp/club_logo.csv'
--   INTO TABLE ClubLogo
--   FIELDS TERMINATED BY ','
--   LINES TERMINATED BY '\n' 
--   IGNORE 1 LINES
--   (@club,@club_logo)
--   SET ClubName=@club,
--           ClubLogo=@club_logo;
-- 
-- # Load NationFlag
-- LOAD DATA INFILE '/tmp/nation_flag.csv'
--   INTO TABLE NationFlag
--   FIELDS TERMINATED BY ','
--   LINES TERMINATED BY '\n' 
--   IGNORE 1 LINES
--   (@nationality,@flag)
--   SET Nation=@nationality,
--           Flag=@flag;

# Load Player
LOAD DATA INFILE '/tmp/origin_table.csv'
  INTO TABLE Player
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n' 
  IGNORE 1 LINES
  (@ID,@name,@full_name,@club,@club_logo,@special,@age,@league,@birth_date,@height_cm,@weight_kg,@body_type,@real_face,@flag,@nationality,@photo,@eur_value,@eur_wage,@eur_release_clause,@overall,@potential,@pac,@sho,@pas,@dri,@def,@phy,@international_reputation,@skill_moves,@weak_foot,@work_rate_att,@work_rate_def,@preferred_foot,@crossing,@finishing,@heading_accuracy,@short_passing,@volleys,@dribbling,@curve,@free_kick_accuracy,@long_passing,@ball_control,@acceleration,@sprint_speed,@agility,@reactions,@balance,@shot_power,@jumping,@stamina,@strength,@long_shots,@aggression,@interceptions,@positioning,@vision,@penalties,@composure,@marking,@standing_tackle,@sliding_tackle,@gk_diving,@gk_handling,@gk_kicking,@gk_positioning,@gk_reflexes,@rs,@RW,@RF,@ram,@rcm,@RM,@rdm,@rcb,@RB,@rwb,@ST,@LW,@CF,@CAM,@CM,@LM,@CDM,@CB,@LB,@lwb,@ls,@LF,@lam,@lcm,@ldm,@lcb,@GK,@1_on_1_rush_trait,@acrobatic_clearance_trait,@argues_with_officials_trait,@avoids_using_weaker_foot_trait,@backs_into_player_trait,@bicycle_kicks_trait,@cautious_with_crosses_trait,@chip_shot_trait,@chipped_penalty_trait,@comes_for_crosses_trait,@corner_specialist_trait,@diver_trait,@dives_into_tackles_trait,@diving_header_trait,@driven_pass_trait,@early_crosser_trait,@fans_favourite_trait,@fancy_flicks_trait,@finesse_shot_trait,@flair_trait,@flair_passes_trait,@gk_flat_kick_trait,@gk_long_throw_trait,@gk_up_for_corners_trait,@giant_throw_in_trait,@inflexible_trait,@injury_free_trait,@injury_prone_trait,@leadership_trait,@long_passer_trait,@long_shot_taker_trait,@long_throw_in_trait,@one_club_player_trait,@outside_foot_shot_trait,@playmaker_trait,@power_free_kick_trait,@power_header_trait,@puncher_trait,@rushes_out_of_goal_trait,@saves_with_feet_trait,@second_wind_trait,@selfish_trait,@skilled_dribbling_trait,@stutter_penalty_trait,@swerve_pass_trait,@takes_finesse_free_kicks_trait,@target_forward_trait,@team_player_trait,@technical_dribbler_trait,@tries_to_beat_defensive_line_trait,@poacher_speciality,@speedster_speciality,@aerial_threat_speciality,@dribbler_speciality,@playmaker_speciality,@engine_speciality,@distance_shooter_speciality,@crosser_speciality,@free_kick_specialist_speciality,@tackling_speciality,@tactician_speciality,@acrobat_speciality,@strength_speciality,@clinical_finisher_speciality,@prefers_rs,@prefers_rw,@prefers_rf,@prefers_ram,@prefers_rcm,@prefers_rm,@prefers_rdm,@prefers_rcb,@prefers_rb,@prefers_rwb,@prefers_st,@prefers_lw,@prefers_cf,@prefers_cam,@prefers_cm,@prefers_lm,@prefers_cdm,@prefers_cb,@prefers_lb,@prefers_lwb,@prefers_ls,@prefers_lf,@prefers_lam,@prefers_lcm,@prefers_ldm,@prefers_lcb,@prefers_gk,@add_pos)
  SET player_id=@ID,
          player_name=@name, 
          nation=@nationality,
          flag=@flag,
          photo=@photo,
          club=@club, 
          clublogo=@club_logo,
          league=@league,
          skills=@skill_moves,
          weak_foot=@weak_foot,
          height=@height_cm,
          weight=@weight_kg,
          pos=@add_pos,
          overall=@overall,
          pace=@pac,
  		  dribbling =@dri,
  		  shooting =@sho,
  		  defending =@def,
  		  physicality =@phy,
  		  passing =@pas;
          
# load GkStat
LOAD DATA INFILE '/tmp/gk.csv'
  INTO TABLE GKStat
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n' 
  IGNORE 1 LINES
  (@ID,@name,@full_name,@club,@club_logo,@special,@age,@league,@birth_date,@height_cm,@weight_kg,@body_type,@real_face,@flag,@nationality,@photo,@eur_value,@eur_wage,@eur_release_clause,@overall,@potential,@pac,@sho,@pas,@dri,@def,@phy,@international_reputation,@skill_moves,@weak_foot,@work_rate_att,@work_rate_def,@preferred_foot,@crossing,@finishing,@heading_accuracy,@short_passing,@volleys,@dribbling,@curve,@free_kick_accuracy,@long_passing,@ball_control,@acceleration,@sprint_speed,@agility,@reactions,@balance,@shot_power,@jumping,@stamina,@strength,@long_shots,@aggression,@interceptions,@positioning,@vision,@penalties,@composure,@marking,@standing_tackle,@sliding_tackle,@gk_diving,@gk_handling,@gk_kicking,@gk_positioning,@gk_reflexes,@rs,@RW,@RF,@ram,@rcm,@RM,@rdm,@rcb,@RB,@rwb,@ST,@LW,@CF,@CAM,@CM,@LM,@CDM,@CB,@LB,@lwb,@ls,@LF,@lam,@lcm,@ldm,@lcb,@GK,@1_on_1_rush_trait,@acrobatic_clearance_trait,@argues_with_officials_trait,@avoids_using_weaker_foot_trait,@backs_into_player_trait,@bicycle_kicks_trait,@cautious_with_crosses_trait,@chip_shot_trait,@chipped_penalty_trait,@comes_for_crosses_trait,@corner_specialist_trait,@diver_trait,@dives_into_tackles_trait,@diving_header_trait,@driven_pass_trait,@early_crosser_trait,@fans_favourite_trait,@fancy_flicks_trait,@finesse_shot_trait,@flair_trait,@flair_passes_trait,@gk_flat_kick_trait,@gk_long_throw_trait,@gk_up_for_corners_trait,@giant_throw_in_trait,@inflexible_trait,@injury_free_trait,@injury_prone_trait,@leadership_trait,@long_passer_trait,@long_shot_taker_trait,@long_throw_in_trait,@one_club_player_trait,@outside_foot_shot_trait,@playmaker_trait,@power_free_kick_trait,@power_header_trait,@puncher_trait,@rushes_out_of_goal_trait,@saves_with_feet_trait,@second_wind_trait,@selfish_trait,@skilled_dribbling_trait,@stutter_penalty_trait,@swerve_pass_trait,@takes_finesse_free_kicks_trait,@target_forward_trait,@team_player_trait,@technical_dribbler_trait,@tries_to_beat_defensive_line_trait,@poacher_speciality,@speedster_speciality,@aerial_threat_speciality,@dribbler_speciality,@playmaker_speciality,@engine_speciality,@distance_shooter_speciality,@crosser_speciality,@free_kick_specialist_speciality,@tackling_speciality,@tactician_speciality,@acrobat_speciality,@strength_speciality,@clinical_finisher_speciality,@prefers_rs,@prefers_rw,@prefers_rf,@prefers_ram,@prefers_rcm,@prefers_rm,@prefers_rdm,@prefers_rcb,@prefers_rb,@prefers_rwb,@prefers_st,@prefers_lw,@prefers_cf,@prefers_cam,@prefers_cm,@prefers_lm,@prefers_cdm,@prefers_cb,@prefers_lb,@prefers_lwb,@prefers_ls,@prefers_lf,@prefers_lam,@prefers_lcm,@prefers_ldm,@prefers_lcb,@prefers_gk,@add_pos)
  SET player_id= @ID,
		  gk=@gk;
          
# load NonGkStat
LOAD DATA INFILE '/tmp/nongk.csv'
  INTO TABLE NonGKStat
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n' 
  IGNORE 1 LINES
  (@ID,@name,@full_name,@club,@club_logo,@special,@age,@league,@birth_date,@height_cm,@weight_kg,@body_type,@real_face,@flag,@nationality,@photo,@eur_value,@eur_wage,@eur_release_clause,@overall,@potential,@pac,@sho,@pas,@dri,@def,@phy,@international_reputation,@skill_moves,@weak_foot,@work_rate_att,@work_rate_def,@preferred_foot,@crossing,@finishing,@heading_accuracy,@short_passing,@volleys,@dribbling,@curve,@free_kick_accuracy,@long_passing,@ball_control,@acceleration,@sprint_speed,@agility,@reactions,@balance,@shot_power,@jumping,@stamina,@strength,@long_shots,@aggression,@interceptions,@positioning,@vision,@penalties,@composure,@marking,@standing_tackle,@sliding_tackle,@gk_diving,@gk_handling,@gk_kicking,@gk_positioning,@gk_reflexes,@rs,@RW,@RF,@ram,@rcm,@RM,@rdm,@rcb,@RB,@rwb,@ST,@LW,@CF,@CAM,@CM,@LM,@CDM,@CB,@LB,@lwb,@ls,@LF,@lam,@lcm,@ldm,@lcb,@GK,@1_on_1_rush_trait,@acrobatic_clearance_trait,@argues_with_officials_trait,@avoids_using_weaker_foot_trait,@backs_into_player_trait,@bicycle_kicks_trait,@cautious_with_crosses_trait,@chip_shot_trait,@chipped_penalty_trait,@comes_for_crosses_trait,@corner_specialist_trait,@diver_trait,@dives_into_tackles_trait,@diving_header_trait,@driven_pass_trait,@early_crosser_trait,@fans_favourite_trait,@fancy_flicks_trait,@finesse_shot_trait,@flair_trait,@flair_passes_trait,@gk_flat_kick_trait,@gk_long_throw_trait,@gk_up_for_corners_trait,@giant_throw_in_trait,@inflexible_trait,@injury_free_trait,@injury_prone_trait,@leadership_trait,@long_passer_trait,@long_shot_taker_trait,@long_throw_in_trait,@one_club_player_trait,@outside_foot_shot_trait,@playmaker_trait,@power_free_kick_trait,@power_header_trait,@puncher_trait,@rushes_out_of_goal_trait,@saves_with_feet_trait,@second_wind_trait,@selfish_trait,@skilled_dribbling_trait,@stutter_penalty_trait,@swerve_pass_trait,@takes_finesse_free_kicks_trait,@target_forward_trait,@team_player_trait,@technical_dribbler_trait,@tries_to_beat_defensive_line_trait,@poacher_speciality,@speedster_speciality,@aerial_threat_speciality,@dribbler_speciality,@playmaker_speciality,@engine_speciality,@distance_shooter_speciality,@crosser_speciality,@free_kick_specialist_speciality,@tackling_speciality,@tactician_speciality,@acrobat_speciality,@strength_speciality,@clinical_finisher_speciality,@prefers_rs,@prefers_rw,@prefers_rf,@prefers_ram,@prefers_rcm,@prefers_rm,@prefers_rdm,@prefers_rcb,@prefers_rb,@prefers_rwb,@prefers_st,@prefers_lw,@prefers_cf,@prefers_cam,@prefers_cm,@prefers_lm,@prefers_cdm,@prefers_cb,@prefers_lb,@prefers_lwb,@prefers_ls,@prefers_lf,@prefers_lam,@prefers_lcm,@prefers_ldm,@prefers_lcb,@prefers_gk,@add_pos)
  SET player_id=@ID,
		  rw=@dw,
          rf=@rf,
		  rm=@rm,
  		  rb=@rb,
  		  st=@st,
  		  cf=@cf,
  		  cam=@cam,
  		  cm=@cm,
  		  cdm=@cdm,
  		  cb=@cb,
  		  lw=@lw,
  		  lm=@lm,
  		  lb=@lb,
  		  lf=@lf;