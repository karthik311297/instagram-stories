    create table userprofile (
        id bigserial not null,
        summary TEXT,
        username varchar(255) not null,
        primary key (id),
        unique (username)
    );

    create table storymetadata (
        id bigserial not null,
        expiry timestamp(6) not null,
        mediaLink varchar(255),
        statustext TEXT,
        profile_id bigint,
        primary key (id)
    );

    alter table if exists storymetadata
       add constraint fk_story_profile
       foreign key (profile_id)
       references userprofile on delete cascade;

    create table inbox (
        story_id bigint not null,
        profile_id bigint not null,
        primary key (profile_id, story_id)
    );

    alter table if exists inbox
       add constraint fk_inbox_profile
       foreign key (profile_id)
       references userprofile;

    alter table if exists inbox
       add constraint fk_inbox_story
       foreign key (story_id)
       references storymetadata;

    INSERT INTO userprofile (summary, username)
    VALUES
        ('Tech enthusiast and blogger', 'john_doe'),
        ('Photographer and traveler', 'alice_wander'),
        ('Software engineer and gamer', 'mark_coder');

    INSERT INTO storymetadata (expiry, mediaLink, statustext, profile_id)
    VALUES
        (NOW() + INTERVAL '1 day', NULL, 'Enjoying the sunset!', 1);




