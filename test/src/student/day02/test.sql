select * from emp order by empno desc;

select * from emp order by empno desc

select * from(select * from emp) where rownum<3;

select * from (select * from (select rownum as rnum,EMPNO from emp) where rnum<=20) where rnum>=11;