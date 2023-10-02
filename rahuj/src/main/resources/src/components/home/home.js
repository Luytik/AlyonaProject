
import { Outlet } from "react-router-dom";
import ButtonHome from "./listarea/buttonHome";

function Home() {
    const homeBtn = [{ name: "доходи", link: "/home/new_income" }, { name: "витрати", link: "/home/new_costs" }, { name: "статистика", link: "/home/new_statistics" }, { name: "login", link: "/login" }]; // дані для домашнього меню
    const listBtn = homeBtn.map((item, index) => <ButtonHome name={item.name} link={item.link} key={index + "m"}></ButtonHome>) //перебирання однакових компонент для виводу меню домашнього

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