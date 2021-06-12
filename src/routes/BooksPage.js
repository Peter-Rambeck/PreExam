import React from "react";
import { useState } from "react";
import { fetchData } from "../apiUtils";
import CenteredContainer from "../components/CenteredContainer";
import { INFO } from "../settings";

function BooksPage() {
  const [library, setLibrary] = useState();

  React.useEffect(() => {
    fetchData("http://localhost:8080/jpareststarter/api/book/all")
      .then((data) => setLibrary(data))
      .catch((err) => console.log(err));
  }, []);

  return (
    <CenteredContainer>
      <div className="row">
        <table className="table">
          <thead>
            <div>
              <tr>
                <th>Autors</th>
                <th>Id</th>
                <th>isbn</th>
                <th>Publish year</th>
                <th>Publisher</th>
                <th>Title</th>
              </tr>
            </div>
          </thead>
          <tbody>
            {library && (
              <div>
                {library.map((item) => (
                  <tr key={item.id}>
                    <td>{item.authors}</td>
                    <td>{item.id}</td>
                    <td>{item.isbn}</td>
                    <td>{item.publishYear}</td>
                    <td>{item.publisher}</td>
                    <td>{item.title}</td>
                  </tr>
                ))}
              </div>
            )}
          </tbody>
        </table>
      </div>
    </CenteredContainer>
  );
}
export default BooksPage;
