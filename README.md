Втора лабораториска вежба по Софтверско инженерство
Петар Кицески,бр.на индекс 203191

Сликата од барање 2 е прикачена на git.
![CFG](https://github.com/203191/SI_2024_lab2_203191/assets/73073653/9d60d670-f501-40fa-9ba6-0075cb5b9405)


2.За Цикоматска комплексност ја користиме формулата M = E - N + 2P 
Но во овај случај ќе пресметаме на следниот начин:
M = N+1
N = предикадни јазли
Каде што имаме 9 предикадни јазли или N = 9(7 if И 2 for циклуси)
7+2+1 = 10. Цикломатската комплексност е 10 за кодот. 

3.Тест случаи според Every Branch критериумот
1.Проверка за allItems да не е null 
input: allItems = null , payment = 500 ==> Exception ("allItems list can't be null!")

2.Дали Item e null
 input: allItems = [Item("milk",111@1,30,0.2),("sugar",2222,90,0)],payment = 200 Output:True
  
  3.Проверка за баркодот или InvalidCharacter на нашиот граф.
 input: allItems = [Item("milk",11@1,30,0.2),("sugar",2222,90,0)],payment = 200
 Output: Exception("Invalid character in item barcode!") 
Ќе фрли исклучок затоа што кај вториот продукт имаме ("milk",11@1,30,0.2) каде што во делот за баркод имаме специјален знак 11@11,но се дозволени само броеви. 

4.Проверка за попуст на Item
 input: allItems = [Item("milk",1111,30,0.1),("sugar",2222,90,-0.2)],payment = 200
 Output: True 
 
 5.
 Проверка дали Item има специјален попуст и баркод
 input: allItems = [Item("milk",1111,100,0.1),("sugar",22222,400,0.2)],payment = 1000 Output: True
 
 6.Проверка на вредноста на продуктите во однос на вкупната сума
 input: allItems = [Item("milk",1111,80,0),("sugar",22222,50,0)],payment = 100 
Output: True

4.Тест случаи според Multiple Condition критериумот
Сите услови се исполнети 
Input Price = 300 Discount = 0.2 Barcode = 02345 
Output = True
 Сите три услови се исполнети: цената е поголема од 300, попустот е поголем од 0, и првиот карактер од баркодот е '0'.

Првиот карактер од баркодот не е '0' 
Input Price = 300 Discount = 0 Barcode = 12345
 Output = false 
Првиот карактер од баркодот не е '0', па условот не е исполнет, независно од вредностите на другите два услови.

Цената на предметот не е поголема од 300
 Input Price = 200 Discount = 0.2 Barcode = 12345
 Output = false 

Цената на предметот не е поголема од 300, па условот не е исполнет, независно од вредностите на другите два услови.
Попустот на предметот не е поголем од 0
 Input Price = 300 Discount = 0 Barcode = 12345
 Output = false 
Попустот не е поголем од 0,па условот не е исполнет

