package com.example.homework;

public class Story {

    private Situation start_story;
    public Situation current_situation;

    Story() {
        start_story = new Situation(
                "Вы пришли на экзамен по физике",
                "Вам достался именно тот билет, который вы плохо знаете! Какая неудача! \n" +
                        "Пока раздают оставшемся людям билеты, профессора плохо следят за вами. \n"
                        + "\n- (1) я по-быстрому спишу с шпаргалки, пока это возможно, ведь меня не спалят?"
                        + "\n- (2) достану телефон. Изи"
                        + "\n- (3) я напишу своими силами экзамен, что-то да прокатит",
                3, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "Шпаргалка",
                "Вы успели что-то списать с нее, но один из профессоров заметил ваше беспокойство. Слежка усилена за вами.",
                0, 0, 30, 20);
        start_story.direction[1] = new Situation(
                "Телефон",
                "Вас спалил Пыркин. Он берет вашу зачетку и смотрит на вас. Вам *****",
                0, 2, 70, 50);
        start_story.direction[2] = new Situation(
                "Я сам",
                "Вы начинаете паниковать, но что-то вспоминаете по ходу написания билета. Видя вашу работу, профессора почти не следят за вами.",
                0, 1, 20, -20);
        current_situation = start_story;
    }

    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
