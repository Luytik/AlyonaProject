import footerlogo from "../../image/logo2.png";

function Footer() {
    return (
        
        <footer className="bg-[#1c2423] text-[#fff] row-[span_1_/_span_2]">
            <div className="container px-4 mx-auto">
                <div className="flex flex-row gap-7 justify-stretch">
                    <div className="logo">
                        <img className="" src={footerlogo} alt="logo"/>
                    </div>
                    <ul className="">
                        <li>adasda</li>
                        <li>adasd</li>
                        <li>asdasd</li>
                    </ul>
                    <ul>
                        <li>sef</li>
                        <li>sedf</li>
                        <li>sef</li>
                    </ul>
                </div>
            </div>
            {/*fixed bottom-0     стиль для фіксованого підвалу знизу сторінки */}
        </footer>
    );
}

export default Footer;