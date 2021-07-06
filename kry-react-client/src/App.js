import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Header from "./Components/Header";
import EndpointsPage from "./Components/EndpoinstPage";
import EndpointDetail from "./Components/EndpointDetail";
import AddEndpoint from "./Components/AddEndpoint";

function App() {
  return (
    <>
      <Router>
        <Header />
        <Switch>
          <Route exact path="/endpoints">
            <EndpointsPage />
          </Route>
          <Route exact path="/endpoints/add">
            <AddEndpoint />
          </Route>
          <Route path="/endpoints/:id">
            <EndpointDetail />
          </Route>
        </Switch>
      </Router>
    </>
  );
}

export default App;
