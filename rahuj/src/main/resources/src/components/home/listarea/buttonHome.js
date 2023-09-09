import { Link } from "react-router-dom";

const ButtonHome = (homeBtn) => {
    return (
        <Link to="/home/new">
            <input className="h-11 w-28 bg-[#295545] text-[#fff] rounded-2xl" type="button" value={homeBtn.name} />
        </Link>
    )

}

export default ButtonHome;