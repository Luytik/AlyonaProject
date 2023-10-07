// Импортируем необходимые модули из библиотеки react
import { createContext, useContext, useState } from "react";
import { BrowserRouter as Router, Route, Routes, Navigate, Outlet, useLocation, useNavigate, Link } from 'react-router-dom';

// Определяем тип контекста с двумя полями: isAuthenticated и setAuth
type AuthContextType = {
  isAuthenticated: boolean; // флаг, показывающий, аутентифицирован ли пользователь
  setAuth: (auth: boolean) => void; // функция для изменения значения isAuthenticated
};

// Создаем контекст с типом AuthContextType и начальными значениями по умолчанию
const AuthContext = createContext<AuthContextType>({
  isAuthenticated: false,
  setAuth: () => { },
});

// Компонент App является корневым компонентом приложения
function Apptest() {
  const [isAuthenticated, setAuth] = useState<boolean>(false); // определяем состояние isAuthenticated

  return (
    // оборачиваем компонент в Router, чтобы использовать роутинг
    <Router>
      {/* используем контекст для передачи значения isAuthenticated и функции setAuth вниз по иерархии компонентов */}
      <AuthContext.Provider value={{ isAuthenticated, setAuth }}>
        <Routes>
          {/* обычные маршруты */}
          <Route path="/" element={<Main />} />
          <Route path="/login" element={<Login />} />

          {/* защищённые маршруты */}
          <Route element={<PrivateRoute />}>
            <Route path='/admin' element={<Admin />} />
            {/* другие защищённые маршруты */}
          </Route>
        </Routes>
      </AuthContext.Provider>
    </Router>

  );
}

// Компонент PrivateRoute используется для защиты определенных маршрутов в приложении.
const PrivateRoute = () => {
  const { isAuthenticated } = useContext(AuthContext); // используем контекст для получения значения isAuthenticated
  const location = useLocation(); // получаем текущий маршрут с помощью хука useLocation()

  return (
    // если пользователь авторизован, то рендерим дочерние элементы текущего маршрута, используя компонент Outlet
    isAuthenticated === true ?
      <Outlet />
      // если пользователь не авторизован, то перенаправляем его на маршрут /login с помощью компонента Navigate
      // свойство replace указывает, что текущий маршрут будет заменен на новый, чтобы пользователь не мог вернуться
      // обратно, используя кнопку "назад" в браузере.
      :
      <Navigate to="/login" state={{ from: location }} replace />
  );
}

// Компонент Login отображает страницу авторизации и обрабатывает вход пользователя.
const Login = () => {
  const { setAuth } = useContext(AuthContext); // используем контекст для получения значений isAuthenticated и setAuth

  const navigate = useNavigate(); // используем хук useNavigate для навигации по маршрутам
  const location = useLocation(); // используем хук useLocation для получения текущего маршрута
  
  // получаем маршрут, на который нужно перенаправить пользователя после авторизации
  const from = location.state?.from?.pathname || '/'; 

  return (
    <>
      <div>Login</div>
      <button type={'button'} onClick={() => {
        setAuth(true); // устанавливаем флаг isAuthenticated в true
        navigate(from, { replace: true }); // перенаправляем пользователя на страницу, которую он запрашивал до авторизации
      }}>Login</button>
    </>
  );
}

// Компонент Main отображает главную страницу приложения.
const Main = () => {
  return (
    <>
      <div>Main</div>
      <Link to='/admin'>Go to Admin Page</Link>
    </>
  );
}

// Компонент Admin отображает страницу для администратора.
const Admin = () => {
  return (
    <>
      <div>Admin</div>
      <Link to='/main'>Go to Main Page</Link>
    </>
  );
}

// Компонент App является корневым компонентом приложения и содержит маршруты и контекст для авторизации.
export default Apptest;
