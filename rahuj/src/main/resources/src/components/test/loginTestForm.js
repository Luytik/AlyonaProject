import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function LoginTestForm() {

    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    async function loginfunc(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/login", {
                login: login,
                password: password,
            }).then((res) => {
                console.log(res.data);

                if (res.data.message == "Email not exits") {
                    alert("Email not exits");
                }
                else if (res.data.message == "Login Success") {

                    navigate('/homeafterlogin');
                }
                else {
                    alert("Incorrect Email and Password not match");
                }
            }, fail => {
                console.error(fail); // Error!
            });
        }

        catch (err) {
            alert(err);
        }

    }

    return (
        <>

            <form className="grid grid-cols-2 gap-4 justify-items-center lg:px-20" onSubmit={loginfunc}>
                <span className=""> Ваш Email: </span>
                <input
                    className=""
                    type="text"
                    name="login"
                    value={login}
          onChange={(event) => {
            setLogin(event.target.value);
          }}
                />
                <span > Ваш пароль: </span>
                <input className=""
                    type="password"
                    name="password"
                    value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
                />
                <div className="w-min mx-auto col-span-2">
                    <input
                        type="submit"
                        value="login"
                        className=" bg-[#295545] text-[#fff] rounded-2xl p-3"
                    />
                </div>


            </form>

        </>

    )
}

export default LoginTestForm;