import ButtonHome from "../home/listarea/buttonHome"
const LoginPage = () => {
    return (
        <>
        <div className="bg-[#9db0b0] p-5 my-5 rounded-2xl gap-5 w-1/2 mx-auto">
        <div className="my-5 text-center font-bold text-lg">Авторизуватись:</div>
        <form className="flex flex-col gap-3">
            <div><span> Ваш Email: </span><input name="email" type="email"/></div>
            <div><span> Ваш Login: </span><input name="name" type="text"/></div>
            <div><span> Ваш пароль: </span><input name="password" type="password"/></div>
            <ButtonHome name = "ввійти"></ButtonHome>
        </form>
        <div className="my-5 text-center font-bold text-lg">Зареєструватись:</div>
        <form className="grid grid-cols-2 gap-4 justify-items-center lg:px-20">
            <span className=""> Ваш Email: </span><input className="" name="email" type="email"/>
            <span className=""> Ваш Login: </span><input className="" name="name" type="text"/>
            <span > Ваш пароль: </span><input className="" name="password" type="password"/>
            <span > Повторіть пароль: </span><input className="" name="password" type="password"/>
            <div className="w-min mx-auto col-span-2"><ButtonHome name = "зареєструватись"></ButtonHome></div>
            

        </form>
        </div>
        </>
    )
}
 export default LoginPage;