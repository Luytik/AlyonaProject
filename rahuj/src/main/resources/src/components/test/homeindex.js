import LoginPage from "../loginpage/logippage";

const HomeIndex = () => {
  return (
    <>
      <LoginPage />
      <button
        onClick={() => {
          localStorage.removeItem("loginName");
        }}
      >
        EXIT
      </button>
    </>
  );
};
export default HomeIndex;
