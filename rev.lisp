;gnu clisp 2.49
;(print "Hello, world!")
;To reverse the order of List i take the list and check wheather its empty or not
(defun rev (str)
  (if (null str)
      nil
    (append (rev (rest str)) (list (car str)))))