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
  UserName VARCHAR(255),
  Password VARCHAR(255) NOT NULL,
  Email VARCHAR(255),
  IsPremium BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT pk_User_UserName PRIMARY KEY (UserName)
);

CREATE TABLE Free (
  UserName VARCHAR(255),
  SearchCredit INT DEFAULT 20,
  CONSTRAINT pk_Free_UserName
    PRIMARY KEY (UserName),
  CONSTRAINT fk_Free_UserName
    FOREIGN KEY (UserName)
    REFERENCES User(UserName)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Premium (
  UserName VARCHAR(255),
  ExpireDate DATE NOT NULL,
  VIPExp DATE NOT NULL,
  VIPLevel INT,
  CreditCardNum BIGINT,
  CreditCardExp DATE NOT NULL,
  CONSTRAINT pk_Premium_UserName
    PRIMARY KEY (UserName),
  CONSTRAINT fk_Premium_UserName
    FOREIGN KEY (UserName)
    REFERENCES User(UserName)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Formation (
  FormationName VARCHAR(255),  
  FormationPhoto VARCHAR(255),
  Pos1 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos2 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos3 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos4 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos5 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos6 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos7 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos8 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos9 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos10 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Pos11 ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  CONSTRAINT pk_Formation_FormationName PRIMARY KEY (FormationName)
 );
 
 CREATE TABLE Squad (
  SquadID INT AUTO_INCREMENT,
  SquadName VARCHAR(255),
  FormationName VARCHAR(255),
  Chemisty INT,
  Rating INT,
  CONSTRAINT pk_Squad_SquadID PRIMARY KEY(SquadID),
  CONSTRAINT fk_Squad_FormationName 
    FOREIGN KEY (FormationName)
    REFERENCES Formation(FormationName)
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
  PlayerID BIGINT,
  PlayerName VARCHAR(255),
  Nation VARCHAR(255),
  Flag VARCHAR(255),
  Photo VARCHAR(255),
  ClubName VARCHAR(255),
  ClubLogo VARCHAR(255),
  LeagueName VARCHAR(255),
  Skills INT,
  WeakFoot INT,
  Height INT,
  Weight INT,
  Pos ENUM('RW','RF','RM','RB','ST','CF','CAM','CM','CDM','CB','LW','LM','LB','LF','GK'),
  Overall INT,
  CONSTRAINT pk_Player_PlayerID PRIMARY KEY (PlayerID)
  -- CONSTRAINT fk_Player_ClubName FOREIGN KEY (ClubName)
--     REFERENCES ClubLogo(ClubName)
--     ON UPDATE CASCADE ON DELETE SET NULL,
--   CONSTRAINT fk_Player_Nation FOREIGN KEY (Nation)
--     REFERENCES NationFlag(Nation)
--     ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE GKStat (
  PlayerID BIGINT,
  Diving INT,
  Handling INT,
  Reflexs INT,
  Speed INT,
  Kicking INT,
  Positioning INT,
  CONSTRAINT pk_GKStat_PlayerID PRIMARY KEY (PlayerID),
  CONSTRAINT fk_GKStat_PlayerID FOREIGN KEY (PlayerID)
    REFERENCES Player(PlayerID)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE NonGKStat (
  PlayerID BIGINT,
  Pace INT,
  Dribbling INT,
  Shooting INT,
  Defending INT,
  Physicality INT,
  Passing INT,
  CONSTRAINT pk_NonGKStat_StatID PRIMARY KEY (PlayerID),
  CONSTRAINT fk_NonGKStat_StatID FOREIGN KEY (PlayerID)
    REFERENCES Player(PlayerID)
    ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE UserSquadJunction (
  UserName VARCHAR(255),
  SquadID INT,
  CONSTRAINT pk_User_Squad PRIMARY KEY (UserName, SquadID),
  CONSTRAINT fk_UserSquad_User FOREIGN KEY (UserName) 
    REFERENCES User (UserName),
  CONSTRAINT fk_UseSquad_Squad  FOREIGN KEY (SquadID)
  REFERENCES Squad (SquadID)
);

CREATE TABLE SquadPlayerJunction (
  SquadID INT,
  PlayerID BIGINT,
  PosNumber ENUM('ONE','TWO','THREE','FOUR','FIVE','SIX','SEVEN','EIGHT','NINE','TEN','ELEVEN'),
  CONSTRAINT pk_Squad_Player PRIMARY KEY (SquadID,PlayerID),
  CONSTRAINT fk_SquadPlayer_Squad  FOREIGN KEY (SquadID)
    REFERENCES Squad (SquadID),
  CONSTRAINT fk_SquadPlayer_Player FOREIGN KEY (PlayerID) 
    REFERENCES Player (PlayerID)
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
  SET PlayerID=@ID,
          PlayerName=@name, 
          Nation=@nationality,
          Flag=@flag,
          Photo=@photo,
          ClubName=@club, 
          ClubLogo=@club_logo,
          LeagueName=@league,
          Skills=@skill_moves,
          WeakFoot=@weak_foot,
          Height=@height_cm,
          Weight=@weight_kg,
          Pos=@add_pos,
          Overall=@overall;
          
# load GkStat
LOAD DATA INFILE '/tmp/gk.csv'
  INTO TABLE GKStat
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n' 
  IGNORE 1 LINES
  (@ID,@name,@full_name,@club,@club_logo,@special,@age,@league,@birth_date,@height_cm,@weight_kg,@body_type,@real_face,@flag,@nationality,@photo,@eur_value,@eur_wage,@eur_release_clause,@overall,@potential,@pac,@sho,@pas,@dri,@def,@phy,@international_reputation,@skill_moves,@weak_foot,@work_rate_att,@work_rate_def,@preferred_foot,@crossing,@finishing,@heading_accuracy,@short_passing,@volleys,@dribbling,@curve,@free_kick_accuracy,@long_passing,@ball_control,@acceleration,@sprint_speed,@agility,@reactions,@balance,@shot_power,@jumping,@stamina,@strength,@long_shots,@aggression,@interceptions,@positioning,@vision,@penalties,@composure,@marking,@standing_tackle,@sliding_tackle,@gk_diving,@gk_handling,@gk_kicking,@gk_positioning,@gk_reflexes,@rs,@RW,@RF,@ram,@rcm,@RM,@rdm,@rcb,@RB,@rwb,@ST,@LW,@CF,@CAM,@CM,@LM,@CDM,@CB,@LB,@lwb,@ls,@LF,@lam,@lcm,@ldm,@lcb,@GK,@1_on_1_rush_trait,@acrobatic_clearance_trait,@argues_with_officials_trait,@avoids_using_weaker_foot_trait,@backs_into_player_trait,@bicycle_kicks_trait,@cautious_with_crosses_trait,@chip_shot_trait,@chipped_penalty_trait,@comes_for_crosses_trait,@corner_specialist_trait,@diver_trait,@dives_into_tackles_trait,@diving_header_trait,@driven_pass_trait,@early_crosser_trait,@fans_favourite_trait,@fancy_flicks_trait,@finesse_shot_trait,@flair_trait,@flair_passes_trait,@gk_flat_kick_trait,@gk_long_throw_trait,@gk_up_for_corners_trait,@giant_throw_in_trait,@inflexible_trait,@injury_free_trait,@injury_prone_trait,@leadership_trait,@long_passer_trait,@long_shot_taker_trait,@long_throw_in_trait,@one_club_player_trait,@outside_foot_shot_trait,@playmaker_trait,@power_free_kick_trait,@power_header_trait,@puncher_trait,@rushes_out_of_goal_trait,@saves_with_feet_trait,@second_wind_trait,@selfish_trait,@skilled_dribbling_trait,@stutter_penalty_trait,@swerve_pass_trait,@takes_finesse_free_kicks_trait,@target_forward_trait,@team_player_trait,@technical_dribbler_trait,@tries_to_beat_defensive_line_trait,@poacher_speciality,@speedster_speciality,@aerial_threat_speciality,@dribbler_speciality,@playmaker_speciality,@engine_speciality,@distance_shooter_speciality,@crosser_speciality,@free_kick_specialist_speciality,@tackling_speciality,@tactician_speciality,@acrobat_speciality,@strength_speciality,@clinical_finisher_speciality,@prefers_rs,@prefers_rw,@prefers_rf,@prefers_ram,@prefers_rcm,@prefers_rm,@prefers_rdm,@prefers_rcb,@prefers_rb,@prefers_rwb,@prefers_st,@prefers_lw,@prefers_cf,@prefers_cam,@prefers_cm,@prefers_lm,@prefers_cdm,@prefers_cb,@prefers_lb,@prefers_lwb,@prefers_ls,@prefers_lf,@prefers_lam,@prefers_lcm,@prefers_ldm,@prefers_lcb,@prefers_gk,@add_pos)
  SET PlayerID= @ID,
		  Diving =@gk_diving,
		  Handling= @gk_handling,
		  Reflexs =@gk_reflexes,
  		  Speed =@sprint_speed,
  		  Kicking =@gk_kicking,
  		  Positioning= @gk_positioning;
          
# load NonGkStat
LOAD DATA INFILE '/tmp/nongk.csv'
  INTO TABLE NonGKStat
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n' 
  IGNORE 1 LINES
  (@ID,@name,@full_name,@club,@club_logo,@special,@age,@league,@birth_date,@height_cm,@weight_kg,@body_type,@real_face,@flag,@nationality,@photo,@eur_value,@eur_wage,@eur_release_clause,@overall,@potential,@pac,@sho,@pas,@dri,@def,@phy,@international_reputation,@skill_moves,@weak_foot,@work_rate_att,@work_rate_def,@preferred_foot,@crossing,@finishing,@heading_accuracy,@short_passing,@volleys,@dribbling,@curve,@free_kick_accuracy,@long_passing,@ball_control,@acceleration,@sprint_speed,@agility,@reactions,@balance,@shot_power,@jumping,@stamina,@strength,@long_shots,@aggression,@interceptions,@positioning,@vision,@penalties,@composure,@marking,@standing_tackle,@sliding_tackle,@gk_diving,@gk_handling,@gk_kicking,@gk_positioning,@gk_reflexes,@rs,@RW,@RF,@ram,@rcm,@RM,@rdm,@rcb,@RB,@rwb,@ST,@LW,@CF,@CAM,@CM,@LM,@CDM,@CB,@LB,@lwb,@ls,@LF,@lam,@lcm,@ldm,@lcb,@GK,@1_on_1_rush_trait,@acrobatic_clearance_trait,@argues_with_officials_trait,@avoids_using_weaker_foot_trait,@backs_into_player_trait,@bicycle_kicks_trait,@cautious_with_crosses_trait,@chip_shot_trait,@chipped_penalty_trait,@comes_for_crosses_trait,@corner_specialist_trait,@diver_trait,@dives_into_tackles_trait,@diving_header_trait,@driven_pass_trait,@early_crosser_trait,@fans_favourite_trait,@fancy_flicks_trait,@finesse_shot_trait,@flair_trait,@flair_passes_trait,@gk_flat_kick_trait,@gk_long_throw_trait,@gk_up_for_corners_trait,@giant_throw_in_trait,@inflexible_trait,@injury_free_trait,@injury_prone_trait,@leadership_trait,@long_passer_trait,@long_shot_taker_trait,@long_throw_in_trait,@one_club_player_trait,@outside_foot_shot_trait,@playmaker_trait,@power_free_kick_trait,@power_header_trait,@puncher_trait,@rushes_out_of_goal_trait,@saves_with_feet_trait,@second_wind_trait,@selfish_trait,@skilled_dribbling_trait,@stutter_penalty_trait,@swerve_pass_trait,@takes_finesse_free_kicks_trait,@target_forward_trait,@team_player_trait,@technical_dribbler_trait,@tries_to_beat_defensive_line_trait,@poacher_speciality,@speedster_speciality,@aerial_threat_speciality,@dribbler_speciality,@playmaker_speciality,@engine_speciality,@distance_shooter_speciality,@crosser_speciality,@free_kick_specialist_speciality,@tackling_speciality,@tactician_speciality,@acrobat_speciality,@strength_speciality,@clinical_finisher_speciality,@prefers_rs,@prefers_rw,@prefers_rf,@prefers_ram,@prefers_rcm,@prefers_rm,@prefers_rdm,@prefers_rcb,@prefers_rb,@prefers_rwb,@prefers_st,@prefers_lw,@prefers_cf,@prefers_cam,@prefers_cm,@prefers_lm,@prefers_cdm,@prefers_cb,@prefers_lb,@prefers_lwb,@prefers_ls,@prefers_lf,@prefers_lam,@prefers_lcm,@prefers_ldm,@prefers_lcb,@prefers_gk,@add_pos)
  SET PlayerID=@ID,
		  Pace=@pac,
  		  Dribbling =@dri,
  		  Shooting =@sho,
  		  Defending =@def,
  		  Physicality =@phy,
  		  Passing =@pas;