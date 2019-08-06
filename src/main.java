/**
*
*@author SeriosWolf
*
*/


import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class main extends JPanel {

    //Основаная функция вызывается при запуске программы, содержит в себе все инструкции на исполнение
    public static void main(String[] args) {
        //Вызов функции рисования окна
        CreateField();

    }

    //Функция рисования окна
    public static void CreateField()
    {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new main());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    //Заполняет окно содержимым
    public void paint(Graphics g)
    {
        //Вызов метода рисования у предка
        super.paint(g);
        //Создание пустого прямоугольника
        g.clearRect(100,100,400,400);
        //Ширина одной клетки
        int stepConstX = 50;
        //Координата левого верхнего угла текущей клетки по оси Х
        int stepCurrentX = 0;
        //Высота одной клетки
        int stepConstY = 50;
        //Координата левого верхнего угла текущей клетки по оси У
        int stepCurrentY = 0;
        //Цикл отрисовки прямоугольного поля 8х8 клеток
        //Проход поля в оси Х
        for(int i = 0; i < 8; i++)
        {
            //Проход поля по У
            for(int j = 0; j < 8; j++)
            {
                //Координата левого верхнего угла по оси Х
                stepCurrentX = stepConstX * (i + 1);
                //Координата левого верхнего угла по оси У
                stepCurrentY = stepConstY * (j + 1);
                //Отрисовать клетку с текущими координатами
                g.drawRect(100, 100, stepCurrentY, stepCurrentX);


            }
        }
        //Создание координат вершин графа в нарисованном поле с клетками
        ArrayList<Integer>vIndex1 = new ArrayList<Integer>(),
                vIndex2 = new ArrayList<Integer>(),
                vIndex3 = new ArrayList<Integer>(),
                vIndex4 = new ArrayList<Integer>(),
                vIndex5 = new ArrayList<Integer>();
        //Заполнение координат 1-й вершины графа
        //Добавление координат по оси Х
        vIndex1.add(6);
        //Добавление координат по оси У
        vIndex1.add(2);

        //Заполнение координат 2-й вершины графа
        vIndex2.add(4);
        vIndex2.add(3);


        //Заполнение координат 3-й вершины графа
        vIndex3.add(2);
        vIndex3.add(4);


        //Заполнение координат 4-й вершины графа
        vIndex4.add(3);
        vIndex4.add(7);


        //Заполнение координат 5-й вершины графа
        vIndex5.add(7);
        vIndex5.add(5);


        //Создание списков вершин смежных с текущей вершиной графа
        ArrayList<Vortex> vList1 = new ArrayList<Vortex>();
        ArrayList<Vortex> vList2 = new ArrayList<Vortex>();
        ArrayList<Vortex> vList3 = new ArrayList<Vortex>();
        ArrayList<Vortex> vList4 = new ArrayList<Vortex>();
        ArrayList<Vortex> vList5 = new ArrayList<Vortex>();


        //Создание вершин графа
        Vortex v1 = new Vortex(vIndex1, vList1);
        Vortex v2 = new Vortex(vIndex2, vList2);
        Vortex v3 = new Vortex(vIndex3, vList3);
        Vortex v4 = new Vortex(vIndex4, vList4);
        Vortex v5 = new Vortex(vIndex5, vList5);

        //Заполнение списков смежных вершин
        //Смежные 1-й вершины
        vList1.add(v2);
        //Смежные 2-й вершины
        vList2.add(v1);
        vList2.add(v3);
        vList2.add(v5);
        //Смежные 3-й вершины
        vList3.add(v2);
        vList3.add(v4);
        //Смежные 4-й вершины
        vList4.add(v3);
        vList4.add(v5);
        //Смежные 5-й вершины
        vList5.add(v2);
        vList5.add(v4);
        //Задача цвета вершин графа
        g.setColor(Color.YELLOW);
        //Создание списка всех вершин графа
        ArrayList<Vortex> vList = new ArrayList<Vortex>();
        //Добавление всех вершин в список
        vList.add(v1);
        vList.add(v2);
        vList.add(v3);
        vList.add(v4);
        vList.add(v5);



        //Цикл отрисовки всех вершин графа в клетках
        for(int i = 0; i < vList.size(); i++)
        {
            g.setColor(Color.YELLOW);
            //Получить координату по оси Х левого верхнего угла текущей вершины
            stepCurrentX = stepConstX * (vList.get(i).vortexHead.get(0) + 1);
            //Получить координату по оси У левого верхнего угла текущей вершины
            stepCurrentY = stepConstY * (vList.get(i).vortexHead.get(1) + 1);
            //Отрисовать вершины
            g.fillRect(stepCurrentX, stepCurrentY, stepConstY, stepConstX);
            //Задать цвет ребер графа
            g.setColor(Color.BLUE);
            //Цикл прохода по вершинам смещным с текущей
            for(int iVortex = 0; iVortex < vList.get(i).vortexList.size(); iVortex++)
            {
                //Создание координат начала и конца ребра
                int x1,x2,y1,y2;
                //Координаты Х и У центра текущей вершины
                x1=stepConstX*(vList.get(i).vortexHead.get(0)+1)+stepConstX/2;
                y1=stepConstY*(vList.get(i).vortexHead.get(1)+1)+stepConstY/2;
                //Координаты Х и У центра некоторой вершины из списка смежных с текущей
                x2=stepConstX*(vList.get(i).vortexList.get(iVortex).vortexHead.get(0)+1)+stepConstX/2;
                y2=stepConstY*(vList.get(i).vortexList.get(iVortex).vortexHead.get(1)+1)+stepConstY/2;
                //Отрисовка ребра
                g.drawLine(x1, y1, x2, y2);
            }

        }
        //Создание списка содержащих начало и конец пути
        ArrayList<Vortex> vListWay = new ArrayList<Vortex>();
        //Добавление в список начала пути
        vListWay.add(v1);
        //Добавление в список конца пути
        vListWay.add(v4);
        //Построение пути между началом и концом

        ArrayList<Vortex> ChainWay = createChain(vListWay);
        //Цикл прохода всех вершин входящих в путь
        for(int i = 0; i < ChainWay.size(); i++)
        {
            //Задать цвет вершины входящей в путь
            g.setColor(Color.GREEN);
            //Получение координат Х и У левого верхнего угла текущей вершины из входящих в путь
            stepCurrentX = stepConstX * (ChainWay.get(i).vortexHead.get(0) + 1);
            stepCurrentY = stepConstY * (ChainWay.get(i).vortexHead.get(1) + 1);
            //Отрисовка текущей вершины из входящих в путь
            g.fillRect(stepCurrentX, stepCurrentY, stepConstY, stepConstX);


        }
        //Цвет ребер входящих в путь
        g.setColor(Color.RED);
        //Цикл построения ребер между вершинами входящими в путь
        //Ребро между текущей вершиной и следующей за ней
        //У последней вершины нету следующей за ней
        //Цикл идет до предпоследней вершины, потому что она последняя у которой есть следующая за ней
        for(int i = 0; i < ChainWay.size()-1; i++)
        {
            //Создание координат центров текущей вершины и центра следующей за ней
            int x1,x2,y1,y2;
            //Получение координат центра текущей вершины
            x1=stepConstX*(ChainWay.get(i).vortexHead.get(0)+1)+stepConstX/2;
            y1=stepConstY*(ChainWay.get(i).vortexHead.get(1)+1)+stepConstY/2;
            //Получение координат центра следующей вершины
            x2=stepConstX*(ChainWay.get(i+1).vortexHead.get(0)+1)+stepConstX/2;
            y2=stepConstY*(ChainWay.get(i+1).vortexHead.get(1)+1)+stepConstY/2;
            //Отрисовка ребра
            g.drawLine(x1, y1, x2, y2);


        }
    }

    //Построение пути между 2-мя вершинами
    public static ArrayList<Vortex> createChain(ArrayList<Vortex> vList)
    {
        //Создание списка всех путей
        ArrayList<ArrayList<Vortex>> chainList = new ArrayList<ArrayList<Vortex>>(),
                //Список временно хранящий все пути на данный момент
                chainListBuff = new ArrayList<ArrayList<Vortex>>();
        //Создание пути содержащего вершины
        ArrayList<Vortex> chain = new ArrayList<Vortex>(),
                //Результирующий путь между началом и концом
                chainFinal = new ArrayList<Vortex>();


        //Создание 1-й цепи с начала пути
        chain.add(vList.get(0));
        //Добавление 1-й цепи с началом пути в список всех путей
        chainList.add((ArrayList<Vortex>)chain.clone());
        //Счетчик числа подходящих путей
        int k = 0;
        //Пока не найден не 1 подходящий путь
        while(k == 0)
        {
            //Размер самого длинного пути в списке путей
            int chainLengthMax = 0;
            //Проход по всем путям в списке путей
            for(int i = 0;i < chainList.size(); i++)
            {
                //Если какой-то путь больше самого пути
                if (chainList.get(i).size() > chainLengthMax)
                {
                    //то сделать его длинну максимальной
                    chainLengthMax = chainList.get(i).size();
                }
            }
            //Проход по всем путям в списке путей
            for(int i1 = 0; i1 < chainList.size(); i1++)
            {
                //Если длинна данного пути совпадает с максимально возможной в списке путей
                if(chainList.get(i1).size() == chainLengthMax)
                {
                    //то тогда стать на последнюю вершину и пройти по списку всех смежных с ней,
                    for(int i = 0; i < chainList.get(i1).get(chainList.get(i1).size() - 1).vortexList.size(); i++)
                    {
                        //Сделать копию текущего пути
                        chain = (ArrayList<Vortex>)chainList.get(i1).clone();
                        //Получить текущую вершину из списка смежных
                        ArrayList<Integer> VortexHead = chainList.get(i1).get(chainList.get(i1).size() - 1).vortexList.get(i).vortexHead;
                        //Двигатся по списку всех вершин пока не встретиться текущая смежная
                        int counter = 0;
                        while(Vortex.vList.get(counter).vortexHead != VortexHead)
                        {
                            counter++;
                        }
                        //К копии текущего пути добавить найденую смежную вершину
                        chain.add(Vortex.vList.get(counter));
                        //Положить полученный путь в список всех путей
                        chainList.add((ArrayList<Vortex>)chain.clone());
                        //Очистить временное хранилище для пути
                        chain.clear();
                    }

                }
            }
            //Очистить временное хранилище для списка путей
            chainListBuff.clear();
            //Пройтись по всем путям из списка путей
            for(int i = 0; i < chainList.size();i++)
            {
                //Установить счетчик повторений вершин в списке путей == 0
                int counterGlobal=0;
                //Пройтись по всем вершинам текущего пути из списка путей
                for (int j = 0; j < chainList.get(i).size();j++)
                {
                    //Пройтись по всем вершинам графа
                    for(int i1 = 0; i1 < Vortex.vList.size(); i1++)
                    {
                        //Установить счетчик повторений вершин в пути == 0
                        int counter = 0;
                        //ДВижение по выбранному пути
                        for(int j1 = 0; j1 < chainList.get(i).size(); j1++)
                        {
                            //Если в ввыбраном пути текущая вершина встречаеться в списке всех верщин
                            if(Vortex.vList.get(i1) == chainList.get(i).get(j1))
                            {
                                //то увеличить число ее повторений в данном пути
                                counter++;
                            }
                        }

                    }

                }
                //Если в пути нету петлей
                if(counterGlobal < 1)
                {
                    //добавить пути в временное хранилище списка всех путей
                    chainListBuff.add(chainList.get(i));
                }
            }
            //Присвоить списку всех путей значение с временного хранилища списка всех путей
            chainList = (ArrayList<ArrayList<Vortex>>)chainListBuff.clone();
            //Теперь в списке всех путей нет путей с петлями
            //Двигаемся по всем путям из списка всех путей
            for(int i = 0; i < chainList.size(); i++)
            {
                //Встреча вершины конца в текущем пути
                boolean bVal4 = chainList.get(i).contains(vList.get(1));
                //Если эта вершина встретилась в пути
                if(bVal4)
                {
                    //Пройтись по всем вершинам этого пути
                    for (int j = 0; j < chainList.get(i).size();j++)
                    {
                        //Вывести каждую вершину пути в консоль
                        System.out.print("("+chainList.get(i).get(j).vortexHead.get(0)+"|"+chainList.get(i).get(j).vortexHead.get(1)+")" + "->");
                    }
                    //Увеличить счетчик подходящий путей на 1
                    k++;
                    //Текущий путь сделать финальным между 2мя вершинами
                    chainFinal = (ArrayList<Vortex>)chainList.get(i).clone();
                    System.out.println();

                    //Прервать цикл поиска вершин
                    break;

                }

            }

        }
        //Вернуть финальный путь между 2-мя вершинами
        return chainFinal;

    }
	/*
	public static void printVortex(Vortex v, Graphics g){



        int stepConstX = 50;
        int stepCurrentX = 0;
        int stepConstY = 50;
        int stepCurrentY = 0;

    	stepCurrentX = stepConstX * (v.vortexHead.get(0) + 1);
    	stepCurrentY = stepConstY * (v.vortexHead.get(1) + 1);

		g.fillRect(stepCurrentX, stepCurrentY, stepConstY, stepConstX);

	}
*/
}
