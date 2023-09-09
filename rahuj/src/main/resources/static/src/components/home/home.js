
import { Outlet} from "react-router-dom";
import ButtonHome from "./listarea/buttonHome";

function Home() {
    //кнопки для навігації між таблицями на домашній сторінці
    const homeBtn = ["доходи", "витрати", "статистика"]; // дані як назва БД
    const listBtn = homeBtn.map((item) => <ButtonHome name={item} ></ButtonHome>) //перебирання однакових компонент для виводу

    //дані для таблиці

    //const table = [{name: "Доходи", category: "прродукти", summ: "125", date: "12.11.22"},
    // {name: "Доходи", category: "прродукти", summ: "125", date: "12.11.22"},
    //{name: "Доходи", category: "прродукти", summ: "125", date: "12.11.22"},
    //{name: "Доходи", category: "прродукти", summ: "125", date: "12.11.22"},]

    // const tableItem = table.map((item) => <ul className="bg-[#52aea3] flex place-content-around p-3 rounded-xl"><LisstFinans>{item}</LisstFinans></ul>)

    return (

        <main className="homepage">
            <div className="container px-4 mx-auto min-h-full">
                <nav className="flex gap-2 place-content-end">
                    {listBtn}
                </nav>
                <div className="">
                    <Outlet />

                </div>

            </div>


        </main>

    )
}
export default Home;