import React from "react";
import { useState } from "react";
import { fetchData } from "../apiUtils";
import CenteredContainer from "../components/CenteredContainer";
import { INFO } from "../settings";

function LibraryPage() {
  const [library, setLibrary] = useState();

  React.useEffect(() => {
    fetchData("http://localhost:8080/jpareststarter/api/library/getlibrary")
      .then((data) => setLibrary(data))
      .catch((err) => console.log(err));
  }, []);

  return (
    <CenteredContainer>
      <div className="row">
        <table className="table">
          <thead>
            <div>
              <h1>Libraries</h1>
            </div>
          </thead>
          <tbody>
            <div>
              <tr>
                <td>{library && <h4>{library.name}</h4>}</td>
              </tr>
            </div>
          </tbody>
        </table>
      </div>
    </CenteredContainer>
  );
}

export default LibraryPage;
