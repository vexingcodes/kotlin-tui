import ncurses.*

fun main(args: Array<String>) {
    initscr()
    cbreak()
    noecho()
    clear()
    mvaddstr(0, 0, "Press any key to exit!")
    refresh()
    getch()
    endwin()
}
