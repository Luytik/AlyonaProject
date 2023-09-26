import { Link } from 'react-router-dom';
import logo from '../../image/logo1.png'

function Header() {
    return (
        <header className="bg-[#D5D8D8] font-sans font-medium uppercase text-lime-950 text-base row-[span_1_/_span_2]">
            <div className="container px-4 mx-auto py-5">
                <div className="flex flex-row gap-7 justify-stretch">
                    <div className="flex-none">
                        <img className='h-16' src={logo} alt="logo" />
                    </div>
                    <ul className="flex-1 flex flex-row place-content-end gap-7 place-items-center">
                        <li className="headermenu__item "><Link to="/">головна</Link></li>
                        <li className="headermenu__item"><Link to="/page1">фінанси</Link></li>
                        <li className="headermenu__item"><Link to="/page2">форум</Link></li>
                        <li className="headermenu__item"><Link to="/page3">про нас</Link></li>
                        <li className="headermenu__item"><Link to="/home">Мій кабінет</Link></li>
                        
                    </ul>
                </div>
            </div>
        </header>
    );
}

export default Header;