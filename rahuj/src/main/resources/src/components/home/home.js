import { Outlet } from "react-router-dom";
import ButtonHome from "./listarea/buttonHome";
import { useContext } from "react";
import { Login } from "../../App";
import LoginForm from "../loginpage/loginForm";
import RegistrationForm from "../loginpage/registrationForm";

function Home() {
  const homeBtn = [
    { name: "доходи", link: "/home/new_income" },
    { name: "витрати", link: "/home/new_costs" },
    { name: "статистика", link: "/home/new_statistics" },
    { name: "login", link: "/login" },
    { name: "test", link: "/home/testtest" },
  ]; // дані для домашнього меню
  const listBtn = homeBtn.map((item, index) => (
    <ButtonHome
      name={item.name}
      link={item.link}
      key={index + "m"}
    ></ButtonHome>
  )); //перебирання однакових компонент для виводу меню домашнього

  const login = useContext(Login);
  return (
    <main className="homepage bg-gradient-to-br from-[#b1c9b3] via-[#a3cccd] via-[#96a1ad] to-[#79b279] min-h-full">
      <div className="container px-4 mx-auto min-h-full">
        {login[0] ? (
          <nav className="flex gap-2 place-content-end">
            {listBtn}
            {console.log(login[0])}
          </nav>
        ) : (
          <p>для початку залогынтесь</p>
        )}

        <div className="">
          <LoginForm />
          <RegistrationForm />

          <Outlet />
        </div>
      </div>
    </main>
  );
}
export default Home;
