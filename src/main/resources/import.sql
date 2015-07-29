-- 1.1 Level 1 assets
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT) VALUES(11001, 'Coins and banknotes', 1.0);

INSERT INTO NOTE_HEADER(ID, NAME) VALUES(101, 'Total central bank reserves; of which:');
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11002, 'part of central bank reserves that can be drawn in times of stress', 1.0, 101);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11003, 'part of central bank reserves that cannot be drawn in times of stress', 1.0, 101);

INSERT INTO NOTE_HEADER(ID, NAME) VALUES(102, 'Securities with a 0% risk weight:');
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11004, 'issued by sovereigns', 1.0, 102);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11005, 'guaranteed by sovereigns', 1.0, 102);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11006, 'issued or guaranteed by central banks', 1.0, 102);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11007, 'issued or guaranteed by PSEs', 1.0, 102);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11008, 'issued or guaranteed by BIS, IMF, ECB and European Community, or MDBs', 1.0, 102);

INSERT INTO NOTE_HEADER(ID, NAME) VALUES(103, 'For non-0% risk-weighted sovereigns:');
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11009, 'sovereign or central bank debt securities issued in domestic currencies by the sovereign or central bank in the country in which the liquidity risk is being taken or in the bank’s home country', 1.0, 103);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(11010, 'domestic sovereign or central bank debt securities issued in foreign currencies, up to the amount of the bank’s stressed net cash outflows in that specific foreign currency stemming from the bank’s operations in the jurisdiction where the bank’s liquidity risk is being taken', 1.0, 103);

-- 1.2 Level 2A assets
INSERT INTO NOTE_HEADER(ID, NAME) VALUES(104, 'Securities with a 20% risk weight:');
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(12001, 'issued by sovereigns', 0.85, 104);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(12002, 'guaranteed by sovereigns', 0.85, 104);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(12003, 'issued or guaranteed by central banks', 0.85, 104);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(12004, 'issued or guaranteed by PSEs', 0.85, 104);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT, NOTE_HEADER_ID) VALUES(12005, 'issued or guaranteed by MDBs', 0.85, 104);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT) VALUES(12006, 'Non-financial corporate bonds, rated AA- or better', 0.85);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT) VALUES(12007, 'Covered bonds, not self-issued, rated AA- or better', 0.85);

-- 1.2 Level 2B assets
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT) VALUES(13001, 'Residential mortgage-backed securities (RMBS), rated AA or better', 0.75);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT) VALUES(13002, 'Non-financial corporate bonds, rated BBB- to A+ ', 0.5);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT) VALUES(13003, 'Non-financial common equity shares', 0.5);
INSERT INTO NOTE(NOTE_ID, DESCRIPTION, WEIGHT) VALUES(13004, 'Sovereign or central bank debt securities, rated BBB- to BBB+', 0.5);