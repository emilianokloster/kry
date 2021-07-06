import { Link } from "react-router-dom";

const Header = () => {
  return (
    <nav className="navbar">
      <Link className="home-link" to="/endpoints">
        Kry's APIs Poller
      </Link>

      <ul className="nav-menu">
        <li>
          <Link className="links" to="/">
            Logout
          </Link>
        </li>
      </ul>
    </nav>
  );
};

export default Header;
