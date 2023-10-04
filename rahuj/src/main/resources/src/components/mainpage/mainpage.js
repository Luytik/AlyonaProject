import mainimage from '../../image/1-default.jpg';
import ButtonHome from '../home/listarea/buttonHome';
import { Link } from 'react-router-dom';



function Mainpage() {
    return (
        <main className="mainpage h-full">
            <div className="container px-4 mx-auto py-5">
                <div className="articles p-5 rounded-2xl">
                    <article className="flex flex-row gap-7">
                        <div className="basis-1/2">
                            <h2 className='font-bold py-8 text-3xl'>Домашня бухгалтерія. Навіщо вести облік фінансів?</h2>
                            <p>Домашня бухгалтерія – це облік доходів і витрат сімейного бюджету в рамках однієї сім'ї, одного будинку, іншими словами – облік домашніх фінансів.
Ведення домашньої бухгалтерії передбачає постійний контроль за грошовими надходженнями і витрачанням коштів сімейного бюджету.


У цілому можна сказати, що ведення обліку домашніх фінансів аналогічно ведення бухгалтерського обліку на підприємстві, з тією різницею, що домашній облік набагато простіше, для нього не потрібно спеціальної освіти, і сімейні "бухгалтера" підзвітні лише собі та членам своєї сім'ї.

                            </p>
                            <div className='text-end'>
                            <Link to="/finans">Читати...</Link>
                            
                            </div>
                        </div>
                        <div className="basis-1/2">
                            <img className="rounded-2xl" src={mainimage} alt="" />
                        </div>
                    </article>
                </div>
            </div>
        </main>
    )
}
export default Mainpage;