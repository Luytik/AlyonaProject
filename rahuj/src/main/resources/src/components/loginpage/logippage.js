import { useContext } from "react";
import LoginForm from "./loginForm";
import RegistrationForm from "./registrationForm";
import { Login } from "../../App";

const LoginPage = () => {
  const login = useContext(Login);
  return (
    <>
      <div className="container px-4 mx-auto py-5">
        <div className="bg-[#9db0b0] p-5 my-5 rounded-2xl gap-5 w-1/2 mx-auto">
          {login[0] ? (
            <>
              <div className="">ваш логін - {login}</div>
              <button
                className="h-11 px-4 bg-[#295545] text-[#fff] rounded-2xl"
                onClick={() => {
                  localStorage.removeItem("loginName");
                  document.location.reload();
                }}
              >
                EXIT
              </button>
            </>
          ) : (
            <>
              <div className="my-5 text-center font-bold text-lg">
                Авторизуватись:
              </div>
              <LoginForm />
              <div className="my-5 text-center font-bold text-lg">
                Зареєструватись:
              </div>
              <RegistrationForm />
            </>
          )}
        </div>
      </div>
    </>
  );
};
export default LoginPage;
