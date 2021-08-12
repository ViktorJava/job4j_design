-- получить: имена всех person, которые не состоят в компании с id = 5;
-- название компании для каждого человека.
SELECT c.id, c.name || ' : ' || p.name AS info
FROM person p
         JOIN company c ON p.company_id = c.id
WHERE c.id <> 5;

-- Необходимо выбрать название компании с максимальным количеством человек
-- плюс, количество человек в этой компании.
SELECT c.name, count(p.name)
FROM company c
         JOIN person p ON c.id = p.company_id
GROUP BY c.name
ORDER BY count(p.name) DESC
LIMIT 1;