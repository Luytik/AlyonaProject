import footerlogo from "../../image/logo2.png";

function Footer() {
    return (
        
        <footer className="bg-[#1c2423] text-[#fff] row-[span_1_/_span_2]">
            <div className="container h-full px-4 mx-auto">
                <div className="flex flex-row gap-9 items-center place-content-between">
                    <div className="logo w-1/2">
                        <img className=" " src={footerlogo} alt="logo"/>
                    </div>
                    <ul className="text-center">
                        <li>Наші соціальні мережі</li>
                        <li>FB I Tg</li>
                    </ul>
                    <ul className="text-center">
                        <li>Email</li>
                        <li>lichul@gmail.com</li>
                    </ul>
                    <ul className="text-center">
                        <li>Допомога</li>
                        <li>ЛІНК</li>
                    </ul>
                </div>
                <div className="text-center">С ~ Лічи-Та-Чиль ~ 2023р</div>
            </div>
            {/*fixed bottom-0     стиль для фіксованого підвалу знизу сторінки */}
        </footer>
    );
}

export default Footer;