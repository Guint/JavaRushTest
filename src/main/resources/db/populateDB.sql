INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', '{noop}password'),
  ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 1),
  ('ROLE_ADMIN', 2);


INSERT INTO books (title, description, author, isbn, printYear, user_id) VALUES
  ('A Brief History Of Time', 'description', 'Stephen Hawking', '9780857501004', 2015, 1),
  ('The Picture of Dorian Gray', 'description', 'Oscar Wilde', '9781853260155', 1997, 1),
  ('Don Quixote', 'description', 'Miguel de Cervantes', '9780099469698', 2005, 1),
  ('Frankenstein', 'description', 'Mary Shelley', '9780141198965', 2016, 1),
  ('Fahrenheit 451', 'description', 'Ray Bradbury', '9780006546061', 2008, 1),
  ('The Little Prince', 'description', 'Antoine de Saint-Exupery', '9780749707231', 1991, 1),
  ('The Idiot', 'description', 'Fyodor Dostoyevsky', '9780140447927', 2015, 1),
  ('The Call of the Wild', 'description', 'Jack London', '9780141321059', 2008, 1),
  ('Robinson Crusoe', 'description', 'Daniel Defoe', '9780199553976', 2009, 1),
  ('A Game of Thrones', 'description', 'George Martin', '9780006479888', 2009, 1),
  ('The Eye Of The World', 'description', 'Robert Jordan', '9780356503820', 2014, 1),
  ('Eragon', 'description', 'Christopher Paolini', '9780552553209', 2008, 1),
  ('It', 'description', 'Stephen King', '9781444707861', 2011, 1),
  ('Sleeping Beauties', 'description', 'Stephen King', '9781473665194', 2011, 1),
  ('The Shining', 'description', 'Stephen King', '9780307743657', 2012, 1),
  ('The Stand', 'description', 'Stephen King', '9780307743688', 2011, 1),
  ('11.22.63', 'description', 'Stephen King', '9781444727333', 2016, 1),
  ('Mr Mercedes', 'description', 'Stephen King', '9781444788648', 2015, 1),
  ('Finders Keepers', 'description', 'Stephen King', '9781473698956', 2016, 1),
  ('The Dead Zone', 'description', 'Stephen King', '9781444708097', 2011, 1),
  ('Revival', 'description', 'Stephen King', '9781444789218', 2015, 1),
  ('The Eyes of the Dragon', 'description', 'Stephen King', '9781444723229', 2015, 1),
  ('Carrie', 'description', 'Stephen King', '9780307743664', 2011, 1),
  ('The Great Book of Amber', 'description', 'Roger Zelazny', '9780380809066', 2011, 1),
  ('Misery', 'description', 'Stephen King', '9781444720716', 2011, 1),
  ('The Dry', 'description', 'Jane Harper', '9780349142111', 2017, 1),
  ('The Big Sleep and Other Novels', 'description', 'Raymond Chandler', '9780141182612', 2000, 1),
  ('The Maltese Falcon', 'description', 'Dashiell Hammett', '9780752865331', 2008, 1),
  ('The Black Dahlia', 'description', 'James Ellroy', '9780099537861', 2011, 1),
  ('The Long Goodbye', 'description', 'Raymond Chandler', '9780394757681', 1999, 1);