import "../style/loading.css";
import { useNavigate } from "react-router-dom";

function Loading() {
    const navigate = useNavigate()
    function toLogin(){
        navigate("/login");
    }

  return (
    <div className="loadingPage">
      <h1 id="errorMessage">Oops.. Something went wrong, press <button onClick={toLogin}>here</button> to log in!</h1>
     
      <div className="loadingio-spinner-ripple-355f0477yy">
        <div className="ldio-16jqiv4z34s">
          <div></div>
          <div></div>
        </div>
      </div>
    </div>
  );
}
export default Loading;
