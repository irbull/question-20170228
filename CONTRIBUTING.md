# How to contribute
At EclipseSource we love contributions.
The following guide will help you get started.

# Getting Started
To contribute, first begin by forking the project on
GitHub. Once you have forked the project, clone it locally and create a new
feature branch for your work:
```
git checkout -b feature_branch_name
```

## Coding Styles
You should format your code to resemble the existing code. In particular:
 * Only use Unix style line breaks
 * No trailing whitespace
 * Indent by 2 spaces, no tabs


## Committing Code
At EclipseSource we value good commit messages. Since our team is distributed across
the globe, we use the git commit message to as a primary means of communicating. Please
follow these [*Seven Rules of a Great Commit Message*](https://chris.beams.io/posts/git-commit/):
 1. Separate subject from body with a blank line
 2. Limit the subject line to 50 characters
 3. Capitalize the subject line
 4. Do not end the subject line with a period
 5. Use the imperative mood in the subject line
 6. Wrap the body at 72 characters
 7. Use the body to explain what and why vs. how

For example:
```
Summarize changes in around 50 characters or less

More detailed explanatory text, if necessary. Wrap it to about 72
characters or so. In some contexts, the first line is treated as the
subject of the commit and the rest of the text as the body. The
blank line separating the summary from the body is critical (unless
you omit the body entirely); various tools like `log`, `shortlog`
and `rebase` can get confused if you run the two together.

Explain the problem that this commit is solving. Focus on why you
are making this change as opposed to how (the code explains that).
Are there side effects or other unintuitive consequences of this
change? Here's the place to explain them.

Further paragraphs come after blank lines.

 - Bullet points are okay, too

 - Typically a hyphen or asterisk is used for the bullet, preceded
   by a single space, with blank lines in between, but conventions
   vary here

If you use an issue tracker, put references to them at the bottom,
like this:

Resolves: #123
See also: #456, #789
```

# Submitting Pull Requests
If you wish to contribute changes back, first push
your branch to github:
```
git push origin feature_branch_name -u
```
Use the *GitHub* Create Pull Request feature to create the pull request.

