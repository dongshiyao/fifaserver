# Create the schema if necessary.
CREATE SCHEMA IF NOT EXISTS ProjectFIFA;
USE ProjectFIFA;

DROP TABLE IF EXISTS User_Squad_Junction;
DROP TABLE IF EXISTS NonGKStat;
DROP TABLE IF EXISTS GKStat;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Formation;
DROP TABLE IF EXISTS Squad;
DROP TABLE IF EXISTS CreditCard;
DROP TABLE IF EXISTS Free;
DROP TABLE IF EXISTS Premium;
DROP TABLE IF EXISTS User;


CREATE TABLE User (
  UserID INT,
  UserName VARCHAR(255),
  Password VARCHAR(255) NOT NULL,
  # ISADIMN
  IsAdmin BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT pk_User_UserID PRIMARY KEY (UserID)
);

CREATE TABLE Free (
  UserID INT,
  SearchCredit INT,
  CONSTRAINT pk_Free_UserID
    PRIMARY KEY (UserID),
  CONSTRAINT fk_Free_UserID
    FOREIGN KEY (UserID)
    REFERENCES User(UserID)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Premium (
  UserID INT,
  ExpireDate TIMESTAMP NOT NULL,
  VIPLevel INT,
  CONSTRAINT pk_Premium_UserID
    PRIMARY KEY (UserID),
  CONSTRAINT fk_Premium_UserID
    FOREIGN KEY (UserID)
    REFERENCES User(UserID)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE CreditCard (
  CardID INT,
  UserID INT,
  CardNumber BIGINT,
  Expiration DATE NOT NULL,
  CONSTRAINT pk_CreditCard_CardID PRIMARY KEY (CardID),
  CONSTRAINT fk_CreditCard_UserID FOREIGN KEY (UserID)
    REFERENCES User(UserID)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Squad (
  SquadID INT AUTO_INCREMENT,
  SquadName VARCHAR(255),
  FormationID INT,
  PlayerID1 INT,
  PlayerID2 INT,
  PlayerID3 INT,
  PlayerID4 INT,
  PlayerID5 INT,
  PlayerID6 INT,
  PlayerID7 INT,
  PlayerID8 INT,
  PlayerID9 INT,
  PlayerID10 INT,
  PlayerID11 INT,
  Chemisty INT,
  Rating INT,
  CONSTRAINT pk_Squad_SquadID PRIMARY KEY(SquadID)
);

CREATE TABLE Formation (
  FormationID INT AUTO_INCREMENT,
  SquadID INT,
  FormationName VARCHAR(255),
  FormationPhoto VARCHAR(255),
  Pos1 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos2 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos3 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos4 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos5 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos6 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos7 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos8 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos9 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos10 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  Pos11 ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'),
  CONSTRAINT pk_Formation_FormationID PRIMARY KEY (FormationID),
  CONSTRAINT fk_Formation_SquadID FOREIGN KEY (SquadID)
    REFERENCES Squad(SquadID)
    ON UPDATE CASCADE ON DELETE SET NULL
 );

CREATE TABLE Player(
  PlayerID BIGINT,
  PlayerName VARCHAR(255),
  Nation VARCHAR(255),
  Flag VARCHAR(255),
  ClubLogo VARCHAR(255),
  Photo VARCHAR(255),
  Club VARCHAR(255),
  League VARCHAR(255),
  Skills INT,
  WeakFoot INT,
  Height INT,
  Weight INT,
  Age INT,
  ############?????????????
  Pos ENUM('RS','RW','RF','RAM','RCM','RM','RDM','RCB','RB','RWB','ST','LW','CF','CAM','CM','LM','CDM','CB','LB','LWB','LS','LF','LAM','LCM','LDM','LCB','GK'), 
  Overall INT,
  #####???????????
  RS INT,
  RW INT,
  RF INT,
  RAM INT,
  RCM INT,
  RM INT,
  RDM INT,
  RCB INT,
  RB INT,
  RWB INT,
  ST INT,
  LW INT,
  CF INT,
  CAM INT,
  CM INT,
  LM INT,
  CDM INT,
  CB INT,
  LB INT,
  LWB INT,
  LS INT,
  LF INT,
  LAM INT,
  LCM INT,
  LDM INT,
  LCB INT,
  GK INT,
  CONSTRAINT pk_Player_PlayerID PRIMARY KEY (PlayerID)
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

CREATE TABLE User_Squad_Junction (
  UserID INT,
  SquadID INT,
  CONSTRAINT pk_User_Sauad PRIMARY KEY (UserID, SquadID),
  CONSTRAINT fk_User FOREIGN KEY (UserID) 
    REFERENCES User (UserID),
  CONSTRAINT fk_Squad  FOREIGN KEY (SquadID) REFERENCES Squad (SquadID)
);

##################################
# Load Data
##################################

# Load Player
LOAD DATA INFILE '/tmp/complete.csv'
  INTO TABLE Player
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n' 
  IGNORE 1 LINES
  (@ID,@name,@full_name,@club,@club_logo,@special,@age,@league,@birth_date,@height_cm,@weight_kg,@body_type,@real_face,@flag,@nationality,@photo,@eur_value,@eur_wage,@eur_release_clause,@overall,@potential,@pac,@sho,@pas,@dri,@def,@phy,@international_reputation,@skill_moves,@weak_foot,@work_rate_att,@work_rate_def,@preferred_foot,@crossing,@finishing,@heading_accuracy,@short_passing,@volleys,@dribbling,@curve,@free_kick_accuracy,@long_passing,@ball_control,@acceleration,@sprint_speed,@agility,@reactions,@balance,@shot_power,@jumping,@stamina,@strength,@long_shots,@aggression,@interceptions,@positioning,@vision,@penalties,@composure,@marking,@standing_tackle,@sliding_tackle,@gk_diving,@gk_handling,@gk_kicking,@gk_positioning,@gk_reflexes,@rs,@rw,@rf,@ram,@rcm,@rm,@rdm,@rcb,@rb,@rwb,@st,@lw,@cf,@cam,@cm,@lm,@cdm,@cb,@lb,@lwb,@ls,@lf,@lam,@lcm,@ldm,@lcb,@gk,@1_on_1_rush_trait,@acrobatic_clearance_trait,@argues_with_officials_trait,@avoids_using_weaker_foot_trait,@backs_into_player_trait,@bicycle_kicks_trait,@cautious_with_crosses_trait,@chip_shot_trait,@chipped_penalty_trait,@comes_for_crosses_trait,@corner_specialist_trait,@diver_trait,@dives_into_tackles_trait,@diving_header_trait,@driven_pass_trait,@early_crosser_trait,@fans_favourite_trait,@fancy_flicks_trait,@finesse_shot_trait,@flair_trait,@flair_passes_trait,@gk_flat_kick_trait,@gk_long_throw_trait,@gk_up_for_corners_trait,@giant_throw_in_trait,@inflexible_trait,@injury_free_trait,@injury_prone_trait,@leadership_trait,@long_passer_trait,@long_shot_taker_trait,@long_throw_in_trait,@one_club_player_trait,@outside_foot_shot_trait,@playmaker_trait,@power_free_kick_trait,@power_header_trait,@puncher_trait,@rushes_out_of_goal_trait,@saves_with_feet_trait,@second_wind_trait,@selfish_trait,@skilled_dribbling_trait,@stutter_penalty_trait,@swerve_pass_trait,@takes_finesse_free_kicks_trait,@target_forward_trait,@team_player_trait,@technical_dribbler_trait,@tries_to_beat_defensive_line_trait,@poacher_speciality,@speedster_speciality,@aerial_threat_speciality,@dribbler_speciality,@playmaker_speciality,@engine_speciality,@distance_shooter_speciality,@crosser_speciality,@free_kick_specialist_speciality,@tackling_speciality,@tactician_speciality,@acrobat_speciality,@strength_speciality,@clinical_finisher_speciality,@prefers_rs,@prefers_rw,@prefers_rf,@prefers_ram,@prefers_rcm,@prefers_rm,@prefers_rdm,@prefers_rcb,@prefers_rb,@prefers_rwb,@prefers_st,@prefers_lw,@prefers_cf,@prefers_cam,@prefers_cm,@prefers_lm,@prefers_cdm,@prefers_cb,@prefers_lb,@prefers_lwb,@prefers_ls,@prefers_lf,@prefers_lam,@prefers_lcm,@prefers_ldm,@prefers_lcb,@prefers_gk)
  SET PlayerID=@ID,
          PlayerName=@name, 
          Nation=@nationality,
          Flag=@flag,
          ClubLogo=@club_logo,
          Photo=@photo,
          Club=@club, 
          League=@league,
          Skills=@skill_moves,
          WeakFoot=@weak_foot,
          Height=@height_cm,
          Weight=@weight_kg,
          Age=@age,
          #####POS
          Overall=@overall,
          RS=nullif(@rs,''),
          RW=nullif(@rw,''),
          RF=nullif(@rf,''),
          RAM=nullif(@ram,''),
          RCM=nullif(@rcm,''),
          RM=nullif(@rm,''),
          RDM=nullif(@rdm,''),
          RCB=nullif(@rcb,''),
          RB=nullif(@rb,''),
          RWB=nullif(@rwb,''),
          ST=nullif(@st,''),
          LW=nullif(@lw,''),
          CF=nullif(@cf,''),
          CAM=nullif(@cam,''),
          CM=nullif(@cm,''),
          LM=nullif(@lm,''),
          CDM=nullif(@cdm,''),
          CB=nullif(@cb,''),
          LB=nullif(@lb,''),
          LWB=nullif(@lwb,''),
          LS=nullif(@ls,''),
          LF=nullif(@lf,''),
          LAM=nullif(@lam,''),
          LCM=nullif(@lcm,''),
          LDM=nullif(@ldm,''),
          LCB=nullif(@lcb,''),
          # non_gk player do not have gk
          GK=nullif(@gk,'');
          
# load GkStat
LOAD DATA INFILE '/tmp/gk.csv'
  INTO TABLE GKStat
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n' 
  IGNORE 1 LINES
  (@ID,@name,@full_name,@club,@club_logo,@special,@age,@league,@birth_date,@height_cm,@weight_kg,@body_type,@real_face,@flag,@nationality,@photo,@eur_value,@eur_wage,@eur_release_clause,@overall,@potential,@pac,@sho,@pas,@dri,@def,@phy,@international_reputation,@skill_moves,@weak_foot,@work_rate_att,@work_rate_def,@preferred_foot,@crossing,@finishing,@heading_accuracy,@short_passing,@volleys,@dribbling,@curve,@free_kick_accuracy,@long_passing,@ball_control,@acceleration,@sprint_speed,@agility,@reactions,@balance,@shot_power,@jumping,@stamina,@strength,@long_shots,@aggression,@interceptions,@positioning,@vision,@penalties,@composure,@marking,@standing_tackle,@sliding_tackle,@gk_diving,@gk_handling,@gk_kicking,@gk_positioning,@gk_reflexes,@rs,@rw,@rf,@ram,@rcm,@rm,@rdm,@rcb,@rb,@rwb,@st,@lw,@cf,@cam,@cm,@lm,@cdm,@cb,@lb,@lwb,@ls,@lf,@lam,@lcm,@ldm,@lcb,@gk,@1_on_1_rush_trait,@acrobatic_clearance_trait,@argues_with_officials_trait,@avoids_using_weaker_foot_trait,@backs_into_player_trait,@bicycle_kicks_trait,@cautious_with_crosses_trait,@chip_shot_trait,@chipped_penalty_trait,@comes_for_crosses_trait,@corner_specialist_trait,@diver_trait,@dives_into_tackles_trait,@diving_header_trait,@driven_pass_trait,@early_crosser_trait,@fans_favourite_trait,@fancy_flicks_trait,@finesse_shot_trait,@flair_trait,@flair_passes_trait,@gk_flat_kick_trait,@gk_long_throw_trait,@gk_up_for_corners_trait,@giant_throw_in_trait,@inflexible_trait,@injury_free_trait,@injury_prone_trait,@leadership_trait,@long_passer_trait,@long_shot_taker_trait,@long_throw_in_trait,@one_club_player_trait,@outside_foot_shot_trait,@playmaker_trait,@power_free_kick_trait,@power_header_trait,@puncher_trait,@rushes_out_of_goal_trait,@saves_with_feet_trait,@second_wind_trait,@selfish_trait,@skilled_dribbling_trait,@stutter_penalty_trait,@swerve_pass_trait,@takes_finesse_free_kicks_trait,@target_forward_trait,@team_player_trait,@technical_dribbler_trait,@tries_to_beat_defensive_line_trait,@poacher_speciality,@speedster_speciality,@aerial_threat_speciality,@dribbler_speciality,@playmaker_speciality,@engine_speciality,@distance_shooter_speciality,@crosser_speciality,@free_kick_specialist_speciality,@tackling_speciality,@tactician_speciality,@acrobat_speciality,@strength_speciality,@clinical_finisher_speciality,@prefers_rs,@prefers_rw,@prefers_rf,@prefers_ram,@prefers_rcm,@prefers_rm,@prefers_rdm,@prefers_rcb,@prefers_rb,@prefers_rwb,@prefers_st,@prefers_lw,@prefers_cf,@prefers_cam,@prefers_cm,@prefers_lm,@prefers_cdm,@prefers_cb,@prefers_lb,@prefers_lwb,@prefers_ls,@prefers_lf,@prefers_lam,@prefers_lcm,@prefers_ldm,@prefers_lcb,@prefers_gk)
  SET PlayerID= @ID,
		  Diving =@gk_diving,
		  Handling= @gk_handling,
		  Reflexs =@gk_reflexes,
          ######?????????
  		  Speed =@sprint_speed,
  		  Kicking =@gk_kicking,
  		  Positioning= @gk_positioning;
          
# load NonGkStat
LOAD DATA INFILE '/tmp/nongk.csv'
  INTO TABLE NonGKStat
  FIELDS TERMINATED BY ','
  LINES TERMINATED BY '\n' 
  IGNORE 1 LINES
  (@ID,@name,@full_name,@club,@club_logo,@special,@age,@league,@birth_date,@height_cm,@weight_kg,@body_type,@real_face,@flag,@nationality,@photo,@eur_value,@eur_wage,@eur_release_clause,@overall,@potential,@pac,@sho,@pas,@dri,@def,@phy,@international_reputation,@skill_moves,@weak_foot,@work_rate_att,@work_rate_def,@preferred_foot,@crossing,@finishing,@heading_accuracy,@short_passing,@volleys,@dribbling,@curve,@free_kick_accuracy,@long_passing,@ball_control,@acceleration,@sprint_speed,@agility,@reactions,@balance,@shot_power,@jumping,@stamina,@strength,@long_shots,@aggression,@interceptions,@positioning,@vision,@penalties,@composure,@marking,@standing_tackle,@sliding_tackle,@gk_diving,@gk_handling,@gk_kicking,@gk_positioning,@gk_reflexes,@rs,@rw,@rf,@ram,@rcm,@rm,@rdm,@rcb,@rb,@rwb,@st,@lw,@cf,@cam,@cm,@lm,@cdm,@cb,@lb,@lwb,@ls,@lf,@lam,@lcm,@ldm,@lcb,@gk,@1_on_1_rush_trait,@acrobatic_clearance_trait,@argues_with_officials_trait,@avoids_using_weaker_foot_trait,@backs_into_player_trait,@bicycle_kicks_trait,@cautious_with_crosses_trait,@chip_shot_trait,@chipped_penalty_trait,@comes_for_crosses_trait,@corner_specialist_trait,@diver_trait,@dives_into_tackles_trait,@diving_header_trait,@driven_pass_trait,@early_crosser_trait,@fans_favourite_trait,@fancy_flicks_trait,@finesse_shot_trait,@flair_trait,@flair_passes_trait,@gk_flat_kick_trait,@gk_long_throw_trait,@gk_up_for_corners_trait,@giant_throw_in_trait,@inflexible_trait,@injury_free_trait,@injury_prone_trait,@leadership_trait,@long_passer_trait,@long_shot_taker_trait,@long_throw_in_trait,@one_club_player_trait,@outside_foot_shot_trait,@playmaker_trait,@power_free_kick_trait,@power_header_trait,@puncher_trait,@rushes_out_of_goal_trait,@saves_with_feet_trait,@second_wind_trait,@selfish_trait,@skilled_dribbling_trait,@stutter_penalty_trait,@swerve_pass_trait,@takes_finesse_free_kicks_trait,@target_forward_trait,@team_player_trait,@technical_dribbler_trait,@tries_to_beat_defensive_line_trait,@poacher_speciality,@speedster_speciality,@aerial_threat_speciality,@dribbler_speciality,@playmaker_speciality,@engine_speciality,@distance_shooter_speciality,@crosser_speciality,@free_kick_specialist_speciality,@tackling_speciality,@tactician_speciality,@acrobat_speciality,@strength_speciality,@clinical_finisher_speciality,@prefers_rs,@prefers_rw,@prefers_rf,@prefers_ram,@prefers_rcm,@prefers_rm,@prefers_rdm,@prefers_rcb,@prefers_rb,@prefers_rwb,@prefers_st,@prefers_lw,@prefers_cf,@prefers_cam,@prefers_cm,@prefers_lm,@prefers_cdm,@prefers_cb,@prefers_lb,@prefers_lwb,@prefers_ls,@prefers_lf,@prefers_lam,@prefers_lcm,@prefers_ldm,@prefers_lcb,@prefers_gk)
  SET PlayerID=@ID,
		  Pace=@pac,
  		  Dribbling =@dri,
  		  Shooting =@sho,
  		  Defending =@def,
  		  Physicality =@phy,
  		  Passing =@pas;