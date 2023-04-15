select ad.category, sum(turnover_fact.turnover)
from turnover_fact
         inner join time_dim td on turnover_fact.time_dim_id = td.id
         inner join article_dim ad on ad.id = turnover_fact.article_dim_id
where td.year = 2023
  and td.month = 3
group by ad.category;

select ad.category, sum(turnover_fact.turnover)
from turnover_fact
         inner join time_dim td on turnover_fact.time_dim_id = td.id
         inner join article_dim ad on ad.id = turnover_fact.article_dim_id
where td.year = 2023
  and td.month = 3
  and ad.city = 'Nürnberg'
group by ad.category;

select sum(turnover_fact.turnover), td.year, ad.firm
from turnover_fact
         inner join article_dim ad on ad.id = turnover_fact.article_dim_id
         inner join time_dim td on turnover_fact.time_dim_id = td.id
where td.year = 2023
group by rollup (ad.firm, td.year);

select sum(turnover_fact.turnover), ad.city, ad.name
from turnover_fact
         inner join article_dim ad on ad.id = turnover_fact.article_dim_id
group by cube (ad.city, ad.name);

select sum(shipping_cost_fact.shipping_cost), td.year
from shipping_cost_fact
         inner join time_dim td on td.id = shipping_cost_fact.time_dim_id
         inner join staff_dim sd on sd.id = shipping_cost_fact.staff_dim_id
where sd.lastname = 'Setford'
group by td.year;

select sum(turnover_fact.turnover), td.quarter, cd.city
from turnover_fact
         inner join time_dim td on turnover_fact.time_dim_id = td.id
         inner join customer_dim cd on cd.id = turnover_fact.customer_dim_id
where td.year = 2022
  and (
            cd.city = 'Nürnberg'
        or cd.city = 'München'
    )
group by td.quarter, cd.city