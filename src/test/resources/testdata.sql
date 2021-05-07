insert into notifications
(id, date, post_id, read, target_id, triggered_id, type)
values (default, {ts '1969-12-31 19:00:00.00'}, 1, default, 1, 2, 'liked');

insert into notifications
(id, date, post_id, read, target_id, triggered_id, type)
values (default,  {ts '1969-12-31 19:00:00.00'}, 2, default, 2, 3, 'commented');

insert into notifications
(id, date, post_id, read, target_id, triggered_id, type)
values (default, {ts '1969-12-31 19:00:00.00'}, 4, default, 3, 6, 'liked');
