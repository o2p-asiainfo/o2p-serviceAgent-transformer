from java.util import Random
rng = Random()
#This is a comment in Jython
print "Flipping a coin..."
if rng.nextBoolean():
  print "Came up heads"
else:
  print "Came up tails"