import footerlogo from "../../image/logo2.png";

function Footer() {
    return (
        
        <footer className="bg-[#1c2423] w-screen text-[#fff]">
            <div className="container px-4 mx-auto min-h-full py-5">
                <div className="flex flex-row gap-7 justify-stretch">
                    <div className="logo">
                        <img src={footerlogo} alt="logo"/>
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