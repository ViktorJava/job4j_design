SELECT mc.email, p.city, mc.first_name FROM my_contacts mc
JOIN zip_code p ON mc.zip_code = p.zip_code;
