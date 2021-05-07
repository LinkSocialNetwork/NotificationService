insert into notifications
(id, date, post_id, read, target_id, triggered_id, type)
values (default, current_timestamp, 1, default, 1, 2, 'liked');

insert into notifications
(id, date, post_id, read, target_id, triggered_id, type)
values (default, current_timestamp, 2, default, 2, 3, 'commented');

insert into notifications
(id, date, post_id, read, target_id, triggered_id, type)
values (default, current_timestamp, 4, default, 3, 6, 'liked');
