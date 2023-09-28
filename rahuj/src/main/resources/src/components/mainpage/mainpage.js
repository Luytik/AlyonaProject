import mainimage from '../../image/1-default.jpg';
import ButtonHome from '../home/listarea/buttonHome';



function Mainpage() {
    return (
        <main className="mainpage h-full">
            <div className="container px-4 mx-auto py-5">
                <div className="articles p-5 rounded-2xl">
                    <article className="flex flex-row gap-7">
                        <div className="basis-1/2">
                            <h2 className='font-bold py-8 text-3xl'>Домашня бухгалтерія. Навіщо вести облік фінансів?</h2>
                            <p>Багатьом домашня бухгалтерія здається марною та дуже нудною справою. На ведення фінансового обліку потрібно витрачати час. Звісно це може спричиняти певні незручності. Проте системна робота над сімейною бухгалтерією точно принесе позитивні результати.

                            </p>
                            <div className='text-end'>
                            <ButtonHome name = "детальніше"/>
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